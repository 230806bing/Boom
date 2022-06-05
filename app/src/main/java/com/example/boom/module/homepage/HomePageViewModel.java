package com.example.boom.module.homepage;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.viewmodel.BaseViewModel;
import com.example.boom.base.retrofit.RepositoryImpl;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/4 13:59
 */
public class HomePageViewModel extends BaseViewModel<RepositoryImpl> {
    public HomePageViewModel(@NonNull Application application) {
        super(application);
    }
}
