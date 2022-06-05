package com.example.boom.module.community;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/5 16:13
 */
public class PostingViewModel extends BaseViewModel<RepositoryImpl> {
    public PostingViewModel(@NonNull Application application) {
        super(application);
    }
}
