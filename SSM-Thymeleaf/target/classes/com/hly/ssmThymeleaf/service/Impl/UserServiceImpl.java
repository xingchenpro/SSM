package com.hly.ssmThymeleaf.service.Impl;


import com.hly.ssmThymeleaf.dao.UserDao;
import com.hly.ssmThymeleaf.entity.User;
import com.hly.ssmThymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }
}
