package com.learn.mybatis.pojo;

/**
 * @author :hly
 * @date :2018/5/4
 */
public class User {
    private String userRegisterId;
    private String userPassword;
    private String userNickName;

    public User() {
    }

    public User(String userRegisterId, String userPassword, String userNickName) {
        this.userRegisterId = userRegisterId;
        this.userPassword = userPassword;
        this.userNickName = userNickName;
    }

    public String getUserId() {
        return userRegisterId;
    }

    public void setUserId(String userRegisterId) {
        this.userRegisterId = userRegisterId;
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
                "userRegisterId=" + userRegisterId +
                ", userPassword=" + userPassword +
                ", userNickName='" + userNickName + '\'' +
                '}';
    }
}
