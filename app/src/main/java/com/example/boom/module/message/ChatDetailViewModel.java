package com.example.boom.module.message;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * <pre>
 *     author : cc
 *     e-mail : xxx@xx
 *     time   : 2022/06/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ChatDetailViewModel extends BaseViewModel<RepositoryImpl> {
    public ChatDetailViewModel(@NonNull Application application) {
        super(application);
    }
}
