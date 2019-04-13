package com.hly.dao;

import com.hly.entity.User;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/13
 */

public interface UserDao {

    public User selectUser(int id);

}
