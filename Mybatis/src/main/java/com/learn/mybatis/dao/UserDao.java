package com.learn.mybatis.dao;
import com.learn.mybatis.pojo.User;
import java.util.List;

/**
 * @author :hly
 * @date :2018/5/4
 */

/**
 * XML构建映射器，包含一个接口和一个XML，定义一个接口实现增删改查
 */
public interface UserDao {
    public int insertUser(User user);
    public int deleteUser(int userId);
    public int updateUser(User user);
    public User getUser(int userId);
    public List<User> findUser(String userNickName);
}
