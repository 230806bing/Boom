package com.example.boom.base.activity;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.bean.Resource;
import com.example.boom.base.viewmodel.BaseViewModel;
import com.google.gson.JsonSyntaxException;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.leo.utilspro.utils.networks.NetWorkUtils;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

public abstract class BaseActivity<VM extends BaseViewModel,VDB extends ViewDataBinding> extends RxFragmentActivity
            implements View.OnClickListener{

    //获取当前activity布局文件,并初始化我们的binding
    protected abstract int getContentViewId();

    //处理逻辑业务
    protected abstract void processLogic();

    //所有监听放这里
    protected abstract void setListener();

    protected VM mViewModel;
    protected VDB mBinding;

    protected static Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        this.savedInstanceState = savedInstanceState;
        //沉浸式状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
        //初始化binging
        mBinding = DataBindingUtil.setContentView(this, getContentViewId());
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        mBinding.setLifecycleOwner(this);
        //创建我们的ViewModel
        createViewModel();
        processLogic();
        setListener();

    }

    public void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) new ViewModelProvider(this).get(modelClass);
        }
    }

    public Context getContext(){
        return this;
    }

    public abstract class OnCallback<T> implements Resource.OnHandleCallback<T>{
        @Override
        public void onError(Throwable throwable) {
            if (!NetWorkUtils.isNetworkConnected(getContext())){
                ToastUtils.showShort(getContext().getResources().getString(R.string.result_network_error));
                return;
            }
            if (throwable instanceof ConnectException){
                ToastUtils.showShort(R.string.result_server_error);
            } else if (throwable instanceof SocketTimeoutException) {
                ToastUtils.showShort(R.string.result_server_timeout);
            } else if (throwable instanceof JsonSyntaxException) {
                Log.e("出错啦出错啦", throwable+"");
                ToastUtils.showShort(R.string.data_parsing_error);
            } else {
                ToastUtils.showShort(R.string.result_empty_error);
            }
        }

        @Override
        public void onFailure(int errorCode, String msg) {
            ToastUtils.showShort(msg);
        }
    }


}