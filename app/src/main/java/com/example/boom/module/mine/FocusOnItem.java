package com.example.boom.module.mine;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.mine
 * Author：陈冰
 * Date：2022/6/5 11:12
 */
public class FocusOnItem {
    private Integer imageRes;
    private String imageUri;
    private String username;
    private String likedStyle;

    public FocusOnItem() {
    }

    public FocusOnItem(Integer imageRes, String username, String likedStyle) {
        this.imageRes = imageRes;
        this.username = username;
        this.likedStyle = likedStyle;
    }

    public FocusOnItem(String imageUri, String username, String likedStyle) {
        this.imageUri = imageUri;
        this.username = username;
        this.likedStyle = likedStyle;
    }

    public Integer getImageRes() {
        return imageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.imageRes = imageRes;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLikedStyle() {
        return likedStyle;
    }

    public void setLikedStyle(String likedStyle) {
        this.likedStyle = likedStyle;
    }
}
