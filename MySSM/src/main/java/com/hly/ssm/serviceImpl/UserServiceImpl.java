package com.hly.ssm.serviceImpl;

import com.hly.ssm.dao.UserDao;
import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @date :2018/5/13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User selectUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
