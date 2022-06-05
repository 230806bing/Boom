package com.example.boom.module.message;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 18:19
 */
public class ChatViewModel extends BaseViewModel<RepositoryImpl> {
    public ChatViewModel(@NonNull Application application) {
        super(application);
    }
}
