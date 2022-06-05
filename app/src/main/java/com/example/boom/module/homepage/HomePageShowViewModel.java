package com.example.boom.module.homepage;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/5 17:51
 */
public class HomePageShowViewModel extends BaseViewModel<RepositoryImpl> {
    public HomePageShowViewModel(@NonNull Application application) {
        super(application);
    }
}
