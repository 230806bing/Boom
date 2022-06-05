package com.example.boom.module.mine;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.mine
 * Author：陈冰
 * Date：2022/6/5 11:00
 */
public class ActivityFocusOnViewModel extends BaseViewModel<RepositoryImpl> {
    public ActivityFocusOnViewModel(@NonNull Application application) {
        super(application);
    }
}
