package com.example.boom.module.message;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 22:11
 */
public class OfficialItem {
    private Integer mImageRes;
    private String mImageUri;
    private String mTitle;
    private String mContent;
    private String mTime;

    public OfficialItem() {
    }

    public OfficialItem(Integer imageRes, String title, String content, String time) {
        this.mImageRes = imageRes;
        this.mTitle = title;
        this.mContent = content;
        this.mTime = time;
    }

    public OfficialItem(String imageUri, String title, String content, String time) {
        this.mImageUri = imageUri;
        this.mTitle = title;
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

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mUsername) {
        this.mTitle = mUsername;
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
