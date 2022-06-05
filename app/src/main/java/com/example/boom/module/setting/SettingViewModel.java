package com.example.boom.module.setting;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.RepositoryImpl;
import com.example.boom.base.viewmodel.BaseViewModel;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.setting
 * Author：陈冰
 * Date：2022/6/4 22:27
 */
public class SettingViewModel extends BaseViewModel<RepositoryImpl> {
    public SettingViewModel(@NonNull Application application) {
        super(application);
    }
}
