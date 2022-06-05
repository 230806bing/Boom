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
 * Date：2022/6/4 14:25
 */
public class MineViewModel extends BaseViewModel<RepositoryImpl> {
    public MineViewModel(@NonNull Application application) {
        super(application);
    }
}
