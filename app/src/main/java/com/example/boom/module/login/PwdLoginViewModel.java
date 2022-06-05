package com.example.boom.module.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.viewmodel.BaseViewModel;
import com.example.boom.base.retrofit.RepositoryImpl;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.login
 * Author：陈冰
 * Date：2022/6/4 11:22
 */
public class PwdLoginViewModel extends BaseViewModel<RepositoryImpl> {
    public PwdLoginViewModel(@NonNull Application application) {
        super(application);
    }
}
