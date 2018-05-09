package com.learn.mybatis.dao;

import com.learn.mybatis.pojo.PageParam;
import com.learn.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @date :2018/5/4
 */

/**
 * XML构建映射器，包含一个接口和一个XML，定义一个接口实现增删改查
 */
public interface UserDao {
    public int insertUser(User user);

    public int deleteUser(String userRegisterId);

    public User getUser(String userRegisterId);

    public List<User> findUser(String userNickName);

    public int userCount();//用户数量
    //map传递多个参数，根据Id和昵称查用户
    public List<User> findUserIdAndNick(Map<String ,Object> IdAndNickMap);

    //@Param多参数查询,@Param给参数命名，代替pojo名字，根据名字得到参数值，传到Sql中
    public List<User> findUserBaseIdAndNick(@Param("userRegisterId") String userRegisterId,@Param("userNick") String userNickNam);

    //JavaBean传递多个参数,可以另外定义一个参数的pojo
    public List<User> findUserByBean(User user);

    //混合查询
    public List<User> findByMix(@Param("params") User user, @Param("page") PageParam pageParam);

    public List<User> getUserResultMap(String userRegisterId);

    //分页参数RowBounds
    public List<User> findByRowBounds(@Param("uNick")String userNickName, RowBounds rowBounds);

    //更新角色
    public int  updateUser(User user);
}
