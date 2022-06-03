package com.example.boom.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.base
 * Author：陈冰
 * Date：2022/5/11 11:55
 */
public class BaseViewModel<T extends BaseModel> extends AndroidViewModel {
    private T repository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        createRepository();
    }

    private void createRepository() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
