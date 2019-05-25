package com.javahly.service;

import com.javahly.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/16
 */

public class UserService {

    private UserDao dao;

    public UserService(UserDao userDao) {
        this.dao = userDao;
    }

    public void service(){
        dao.test();
    }
}
