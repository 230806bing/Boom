package com.example.boom.base.retrofit.utils;

import androidx.annotation.NonNull;

import com.example.boom.base.retrofit.Constant;
import com.example.boom.base.retrofit.Interceptor.LogInterceptor;
import com.example.boom.base.retrofit.RetrofitApiUrl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description：retrofit单例封装
 * Param：
 * return：
 * PackageName：com.example.shimmer.base.retrofit.utils
 * Author：陈冰
 * Date：2022/1/15 13:20
 */
public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static RetrofitApiUrl mRetrofitApiUrl;

    /**
     * 单例模式
     */
    public static RetrofitApiUrl getRetrofitApiService() {
        if (mRetrofitApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mRetrofitApiUrl == null) {
                    mRetrofitApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mRetrofitApiUrl;
    }

    private RetrofitUtils() {
    }

    public RetrofitApiUrl getRetrofit() {
        // 初始化Retrofit
        RetrofitApiUrl retrofitApiUrl = initRetrofit(initOkHttp()).create(RetrofitApiUrl.class);
        return retrofitApiUrl;
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(Constant.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constant.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constant.DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
    }
}
