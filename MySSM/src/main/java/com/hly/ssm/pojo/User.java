package com.hly.ssm.pojo;

import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @date :2018/5/13
 */

public class User {
    private String userId;
    private String userNickName;
    private String userPassword;

    public User(String userId, String userNickName, String userPassword) {
        this.userId = userId;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
    }
    public User() {
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
