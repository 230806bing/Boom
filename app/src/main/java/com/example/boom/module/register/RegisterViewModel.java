package com.example.boom.module.register;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.register
 * Author：陈冰
 * Date：2022/6/7 20:08
 */
public class RegisterViewModel extends BaseViewModel<RepositoryImpl> {
    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }
}
