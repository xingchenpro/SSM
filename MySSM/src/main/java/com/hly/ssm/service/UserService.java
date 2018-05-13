package com.hly.ssm.service;

import com.hly.ssm.pojo.User;

/**
 * @author :hly
 * @date :2018/5/13
 */
public interface UserService {
    public User selectUserById(String userId);
}
