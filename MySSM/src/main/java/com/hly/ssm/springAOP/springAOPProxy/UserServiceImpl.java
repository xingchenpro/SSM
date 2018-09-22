package com.hly.ssm.springAOP.springAOPProxy;

import com.hly.ssm.pojo.User;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        System.err.println(user.toString());
    }
}
