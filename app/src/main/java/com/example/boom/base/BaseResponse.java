package com.example.boom.base;

import java.io.Serializable;

/**
 * Description：泛型类，可根据后端的返回字段修改属性名
 * Param：
 * return：
 * PackageName：com.example.shimmer.base.retrofitwithrxjava.bean
 * Author：陈冰
 * Date：2022/1/14 18:15
 */
public class BaseResponse<T> implements Serializable {
    private static final int RESULT_SUCCESS = 200;
    private int code;
    private String msg;
    private T data;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess(){
        return RESULT_SUCCESS == code;
    }

    public Boolean isOtherLogin() {
        return code == 100;
    }
}
