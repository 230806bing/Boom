package com.example.boom.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.bean.Resource;
import com.example.boom.base.viewmodel.BaseViewModel;
import com.google.gson.JsonSyntaxException;
import com.leo.utilspro.utils.networks.NetWorkUtils;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * <pre>
 *     author : cc
 *     e-mail : xxx@xx
 *     time   : 2022/05/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class BaseFragment<VM extends BaseViewModel,VDB extends ViewDataBinding> extends RxFragment implements View.OnClickListener{
    protected VDB mBinding;
    protected VM mViewModel;
    protected View mContentView;


    //获取当前activity布局文件
    protected abstract int getContentViewId();

    //处理逻辑业务
    protected abstract void processLogic(Bundle savedInstanceState);

    //所有监听放这里
    protected abstract void setListener();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null){
            mBinding = DataBindingUtil.inflate(inflater,getContentViewId(),null,false);
            mContentView = mBinding.getRoot();
            mBinding.setLifecycleOwner((LifecycleOwner) this);
            createViewModel();
            setListener();
            processLogic(savedInstanceState);
        }else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null){
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    private void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) new ViewModelProvider((ViewModelStoreOwner) this).get(modelClass);
            mViewModel.setObjectLifecycleTransformer(bindToLifecycle());
        }
    }

    public abstract class OnCallback<T> implements Resource.OnHandleCallback<T> {
        @Override
        public void onError(Throwable throwable) {
            if (!NetWorkUtils.isNetworkConnected(getContext())){
                com.blankj.utilcode.util.ToastUtils.showShort(getContext().getResources().getString(R.string.result_network_error));
                return;
            }

            if (throwable instanceof ConnectException){
                com.blankj.utilcode.util.ToastUtils.showShort(R.string.result_server_error);
            } else if (throwable instanceof SocketTimeoutException) {
                com.blankj.utilcode.util.ToastUtils.showShort(R.string.result_server_timeout);
            } else if (throwable instanceof JsonSyntaxException) {
                com.blankj.utilcode.util.ToastUtils.showShort(R.string.data_parsing_error);
            } else {
                com.blankj.utilcode.util.ToastUtils.showShort(R.string.result_empty_error);
            }
        }

        @Override
        public void onFailure(int errorCode, String msg) {
            ToastUtils.showShort(msg);
        }

    }


}
