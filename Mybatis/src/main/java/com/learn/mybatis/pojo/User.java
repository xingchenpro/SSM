package com.learn.mybatis.pojo;

/**
 * @author :hly
 * @date :2018/5/4
 */
public class User {
    private int userId;
    private String userPassword;
    private String userNickName;

    public User() {
    }

    public User(int userId, String userPassword, String userNickName) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickName = userNickName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword=" + userPassword +
                ", userNickName='" + userNickName + '\'' +
                '}';
    }
}
