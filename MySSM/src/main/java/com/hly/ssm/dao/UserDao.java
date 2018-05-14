package com.hly.ssm.dao;

import com.hly.ssm.pojo.User;

/**
 * @author :hly
 * @date :2018/5/13
 */
public interface UserDao {
    public User selectUserById(String userId);
    public int insertUser(User user);
}
