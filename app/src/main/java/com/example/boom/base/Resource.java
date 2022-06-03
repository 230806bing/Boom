package com.example.boom.base;

import android.util.Log;


/**
 * Description：这个用来拓展LiveData
 * Param：
 * return：
 * PackageName：com.example.shimmer.base.bean
 * Author：陈冰
 * Date：2022/1/16 14:18
 */
public class Resource<T> {
    //状态  这里有多个状态 0表示加载中；1表示成功；2表示联网失败；3表示接口虽然走通，但走的失败（如：关注失败）
    public static final int LOADING = 0;
    public static final int SUCCESS = 1;
    public static final int ERROR = 2;
    public static final int FAIL = 3;
    public int code;

    public String msg;
    public T data;
    public Throwable error;
    //单独为fail状态下：可能需要区分错误用
    public int errorCode;

    public Resource(int state, T data, String msg) {
        this.code = state;
        this.msg = msg;
        this.data = data;
    }
    public Resource(int state, Throwable error) {
        this.code = state;
        this.error = error;
    }




    public static <T> Resource<T> loading(String showMsg) {
        return new Resource<>(LOADING, null, showMsg);
    }

    public static <T> Resource<T> success(T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> response(BaseResponse<T> data) {
        if (data != null) {
            if (data.isSuccess()) {
                Log.e("看看data,msg", data.getData()+"__"+data.getMsg());
                return new Resource<T>(SUCCESS, data.getData(),data.getMsg());
            }

//            if (data.isOtherLogin()) {
//                return new Resource<T>(OTHERLOGIN, null, data.getMsg());
//            }
            return new Resource<>(FAIL, null, data.getMsg());
        }
        return new Resource<>(ERROR, null, null);
    }


    public static <T> Resource<T> error(Throwable t) {
        return new Resource<>(ERROR, t);
    }

//    public static <T> Resource<T> progress(int percent, long total) {
//        return new Resource<>(PROGRESS, percent, total);
//    }

    public void handler(OnHandleCallback<T> callback) {
        handlerUnCloseDialog(callback);
        if (code != LOADING) {
            callback.onCompleted();
        }
    }

    //网络加载完成后不消失dialog;(场景：连续请求2个网络。第二个网络要等第一个网络返回的参数，才请求。第一个网络不该关闭dialog)
    public void handlerUnCloseDialog(OnHandleCallback<T> callback) {
        Log.e("TAG", code+"" );
        switch (code) {
            case LOADING:
                callback.onLoading(msg);
                break;
            case SUCCESS:
                callback.onSuccess(data);
                break;
            case FAIL:
                callback.onFailure(errorCode, msg);
                break;
            case ERROR:
                callback.onError(error);
                break;
//            case PROGRESS:
//                callback.onProgress(percent,total);
//                break;
//            case OTHERLOGIN:
//                callback.onOtherLogin(msg);
//                break;
        }
    }


    public interface OnHandleCallback<T> {
        void onLoading(String showMessage);

        void onSuccess(T data);

        void onFailure(int errorCode, String msg);

        void onError(Throwable error);

        void onCompleted();

        void onProgress(int percent,long total);

//        void onOtherLogin(String msg);
    }
}
