package com.example.boom.base;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.boom.base.bean.ParamsBuilder;
import com.example.boom.base.bean.Resource;
import com.example.boom.base.retrofit.RetrofitApiUrl;
import com.example.boom.base.retrofit.utils.BaseResponse;
import com.example.boom.base.retrofit.utils.RetrofitUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.base
 * Author：陈冰
 * Date：2022/5/11 11:55
 */
public class BaseModel {
    public LifecycleTransformer objectLifecycleTransformer;
    public ArrayList<String> onNetTags;

    public RetrofitApiUrl getApiService() {
        return RetrofitUtils.getRetrofitApiService();
    }

    public void setObjectLifecycleTransformer(LifecycleTransformer objectLifecycleTransformer) {
        this.objectLifecycleTransformer = objectLifecycleTransformer;
    }

    public void setOnNetTags(ArrayList<String> onNetTags) {
        this.onNetTags = onNetTags;
    }

    public <T> MutableLiveData<T> observeGo(Observable observable, final MutableLiveData<T> liveData) {
        return observe(observable, liveData, null);
    }

    public <T> MutableLiveData<T> observeGo(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {
        if (paramsBuilder == null) {
            paramsBuilder = ParamsBuilder.build();
        }
        int retryCount = paramsBuilder.getRetryCount();
        if (retryCount > 0) {
            return observeWithRetry(observable, liveData, paramsBuilder);
        } else {
            return observe(observable, liveData, paramsBuilder);
        }
    }


    //统一操作
    private <T> MutableLiveData<T> observe(Observable observable, MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {
        if ( paramsBuilder == null) {
            paramsBuilder = paramsBuilder.build();
        }
        boolean showDialog = paramsBuilder.isShowDialog();
        String loadingMessage = paramsBuilder.getLoadingMessage();

        String oneTag = paramsBuilder.getOneTag();
        if (!TextUtils.isEmpty(oneTag)) {
            if (onNetTags.contains(oneTag)) {
                return liveData;
            }
        }
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable1 -> {
                    if (!TextUtils.isEmpty(oneTag)) {
                        onNetTags.add(oneTag);
                    }
                    if (showDialog) {
                        liveData.postValue((T) Resource.loading(loadingMessage));
                    }
                })
                .doFinally(() -> {
                    if (!TextUtils.isEmpty(oneTag)) {
                        onNetTags.remove(oneTag);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                //.compose(objectLifecycleTransformer)
                .subscribe(o -> {
                    Log.e("执行到了吗？", "进来！！");
                    liveData.postValue((T) Resource.response((BaseResponse<Object>) o));
                }, throwable -> {
                    Log.e("执行到这里了？？", "进来！！");
                    liveData.postValue((T) Resource.error((Throwable) throwable));
                });

        return liveData;
    }


    //把统一操作全部放在这，这是带重连的
    public <T> MutableLiveData<T> observeWithRetry(Observable observable, final MutableLiveData<T> liveData, ParamsBuilder paramsBuilder) {
        if (paramsBuilder == null) {
            paramsBuilder = paramsBuilder.build();
        }
        boolean showDialog = paramsBuilder.isShowDialog();
        String loadingMessage = paramsBuilder.getLoadingMessage();


        String oneTag = paramsBuilder.getOneTag();
        if (!TextUtils.isEmpty(oneTag)) {
            if (onNetTags.contains(oneTag)) {
                return liveData;
            }
        }

        final int maxCount = paramsBuilder.getRetryCount();
        final int[] currentCount = {0};

        Disposable disposable = observable.subscribeOn(Schedulers.io())
                .retryWhen(throwable -> {
                    //如果还没到次数，就延迟5秒发起重连
                    if (currentCount[0] <= maxCount) {
                        currentCount[0]++;
                        return Observable.just(1).delay(5000, TimeUnit.MILLISECONDS);
                    } else {
                        //到次数了跑出异常
                        return Observable.error(new Throwable("重连次数已达最高,请求超时"));
                    }
                })
                .doOnSubscribe(disposable1 -> {
                    if (!TextUtils.isEmpty(oneTag)) {
                        onNetTags.add(oneTag);
                    }
                    if (showDialog) {
                        liveData.postValue((T) Resource.loading(loadingMessage));
                    }
                })
                .doFinally(() -> {
                    if (!TextUtils.isEmpty(oneTag)) {
                        onNetTags.remove(oneTag);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                //.compose(objectLifecycleTransformer)
                .subscribe(o -> {
                    Log.e("执行到了吗？", "进来！！");
                    liveData.postValue((T) Resource.response((BaseResponse<Object>) o));
                }, throwable -> {
                    Log.e("执行到这里了？？", "进来！！");
                    liveData.postValue((T) Resource.error((Throwable) throwable));
                });

        return liveData;
    }




}
