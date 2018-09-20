package com.hly.ssm.dao;

import com.hly.ssm.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @date :2018/5/13
 */
@Repository
public interface UserDao {
    public User selectUserById(String userId);
    public int insertUser(User user);
}
