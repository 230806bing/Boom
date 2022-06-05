package com.example.boom.module.homepage;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/6 0:17
 */
public class MusicShowItem {
    private String mImageUri;
    private Integer mImageRes;
    private String mTitle;
    private String mLocation;
    private String mAddress;
    private String mTime;
    private String mTag;
    private String mPrice;

    public MusicShowItem() {
    }

    public MusicShowItem(Integer imageRes, String title, String location, String address, String time, String tag, String price) {
        this.mImageRes = imageRes;
        this.mTitle = title;
        this.mLocation = location;
        this.mAddress = address;
        this.mTime = time;
        this.mTag = tag;
        this.mPrice = price;
    }

    public MusicShowItem(String imageUri, String title, String location, String address, String time, String tag, String price) {
        this.mImageUri = imageUri;
        this.mTitle = title;
        this.mLocation = location;
        this.mAddress = address;
        this.mTime = time;
        this.mTag = tag;
        this.mPrice = price;
    }

    public String getImageUri() {
        return mImageUri;
    }

    public void setImageUri(String imageUri) {
        this.mImageUri = imageUri;
    }

    public Integer getImageRes() {
        return mImageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.mImageRes = imageRes;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        this.mTag = tag;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }
}
