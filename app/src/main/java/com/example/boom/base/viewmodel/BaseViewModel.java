package com.example.boom.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.boom.base.BaseModel;
import com.example.boom.base.retrofit.RepositoryImpl;
import com.trello.rxlifecycle2.LifecycleTransformer;

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
    private ArrayList<String> onNetTags;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        createRepository();
        onNetTags = new ArrayList<>();
        repository.setOnNetTags(onNetTags);
    }

    public void setObjectLifecycleTransformer(LifecycleTransformer objectLifecycleTransformer) {
        if (repository!=null){
            repository.setObjectLifecycleTransformer(objectLifecycleTransformer);
        }
    }


    private void createRepository() {
        if (repository == null) {
            repository = (T) new RepositoryImpl();
        }
    }

    public T getRepository() {
        return repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
