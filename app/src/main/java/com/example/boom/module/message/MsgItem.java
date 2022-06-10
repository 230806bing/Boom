package com.example.boom.module.message;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/7 11:13
 */
public class MsgItem {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private Integer imageRes;
    private String imageUri;
    private String content;
    private int type;

    public MsgItem() {
    }

    public MsgItem(String imageUri, String content, int type) {
        this.imageUri = imageUri;
        this.content = content;
        this.type = type;
    }

    public MsgItem(Integer imageRes, String content, int type) {
        this.imageRes = imageRes;
        this.content = content;
        this.type = type;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
