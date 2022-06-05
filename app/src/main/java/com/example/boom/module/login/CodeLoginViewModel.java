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
 * Date：2022/6/4 14:00
 */
public class CodeLoginViewModel extends BaseViewModel<RepositoryImpl> {
    public CodeLoginViewModel(@NonNull Application application) {
        super(application);
    }
}
