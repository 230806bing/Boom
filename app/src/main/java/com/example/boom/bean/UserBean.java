package com.example.boom.bean;

import java.io.Serializable;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.bean
 * Author：陈冰
 * Date：2022/6/8 9:18
 */
public class UserBean implements Serializable {

    private Integer userId;
    private String nickname;
    private Integer gender;
    private String city;
    private String birthday;
    private String phone;
    private String introduction;

    public UserBean(Integer userId, String nickname, Integer gender, String city, String birthday, String phone, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.gender = gender;
        this.city = city;
        this.birthday = birthday;
        this.phone = phone;
        this.introduction = introduction;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
