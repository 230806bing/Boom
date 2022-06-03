package com.example.boom.base;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.google.gson.JsonSyntaxException;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
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
}