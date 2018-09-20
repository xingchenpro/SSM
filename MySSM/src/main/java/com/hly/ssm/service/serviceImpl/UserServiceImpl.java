package com.hly.ssm.service.serviceImpl;

import com.hly.ssm.dao.UserDao;
import com.hly.ssm.pojo.User;
import com.hly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :hly
 * @date :2018/5/13
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public User selectUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
