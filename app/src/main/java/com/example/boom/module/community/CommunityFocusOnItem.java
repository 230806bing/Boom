package com.example.boom.module.community;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/5 14:59
 */
public class CommunityFocusOnItem {
    private Integer mImageRes;
    private String mImageUri;
    private String mUsername;
    private String mContent;
    private String mTime;
    private String mTopic;
    private String mShared;
    private String mComment;
    private String mLiked;
    private List<String> mImageList;
    private boolean isFocusOn;

    public CommunityFocusOnItem() {
    }


    public CommunityFocusOnItem(String mImageUri, String mUsername, String mContent, String mTime, String mTopic, String mShared, String mComment, String mLiked, List<String> mImageList, boolean isFocusOn) {
        this.mImageUri = mImageUri;
        this.mUsername = mUsername;
        this.mContent = mContent;
        this.mTime = mTime;
        this.mTopic = mTopic;
        this.mShared = mShared;
        this.mComment = mComment;
        this.mLiked = mLiked;
        this.mImageList = mImageList;
        this.isFocusOn = isFocusOn;
    }

    public CommunityFocusOnItem(Integer mImageRes, String mUsername, String mContent, String mTime, String mTopic, String mShared, String mComment, String mLiked, List<String> mImageList, boolean isFocusOn) {
        this.mImageRes = mImageRes;
        this.mUsername = mUsername;
        this.mContent = mContent;
        this.mTime = mTime;
        this.mTopic = mTopic;
        this.mShared = mShared;
        this.mComment = mComment;
        this.mLiked = mLiked;
        this.mImageList = mImageList;
        this.isFocusOn = isFocusOn;
    }

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(String topic) {
        this.mTopic = topic;
    }

    public String getShared() {
        return mShared;
    }

    public void setShared(String shared) {
        this.mShared = shared;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        this.mComment = comment;
    }

    public String getLiked() {
        return mLiked;
    }

    public void setLiked(String liked) {
        this.mLiked = liked;
    }


    public List<String> getImageList() {
        return mImageList;
    }

    public void setImageList(List<String> imageList) {
        this.mImageList = imageList;
    }

    public boolean isFocusOn() {
        return isFocusOn;
    }

    public void setFocusOn(boolean focusOn) {
        isFocusOn = focusOn;
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
