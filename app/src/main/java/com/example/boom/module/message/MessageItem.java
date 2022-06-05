package com.example.boom.module.message;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 20:48
 */
public class MessageItem {
    private Integer mImageRes;
    private String mImageUri;
    private String mUsername;
    private String mContent;
    private String mTime;

    public MessageItem() {
    }

    public MessageItem(Integer imageRes, String username, String content, String time) {
        this.mImageRes = imageRes;
        this.mUsername = username;
        this.mContent = content;
        this.mTime = time;
    }

    public MessageItem(String imageUri, String username, String content, String time) {
        this.mImageUri = imageUri;
        this.mUsername = username;
        this.mContent = content;
        this.mTime = time;
    }

    public Integer getImageRes() {
        return mImageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.mImageRes = imageRes;
    }

    public String getImageUri() {
        return mImageUri;
    }

    public void setImageUri(String imageUri) {
        this.mImageUri = imageUri;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }
}
