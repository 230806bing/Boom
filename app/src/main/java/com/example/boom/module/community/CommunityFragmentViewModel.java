package com.example.boom.module.community;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.viewmodel.BaseViewModel;
import com.example.boom.base.retrofit.RepositoryImpl;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/4 14:10
 */
public class CommunityFragmentViewModel extends BaseViewModel<RepositoryImpl> {
    public CommunityFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
