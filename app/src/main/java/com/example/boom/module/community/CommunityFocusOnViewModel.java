package com.example.boom.module.community;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.boom.R;
import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/5 14:29
 */
public class CommunityFocusOnViewModel extends BaseViewModel<RepositoryImpl> {

    public CommunityFocusOnViewModel(@NonNull Application application) {
        super(application);
    }
}
