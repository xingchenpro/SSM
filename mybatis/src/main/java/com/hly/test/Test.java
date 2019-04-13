package com.hly.test;

import com.hly.dao.UserDao;
import com.hly.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/13
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //1.
        //User user = sqlSession.selectOne("selectUser",1);
        //2.
        UserDao userDao =sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser(1);
        System.err.println(user);





    }
}
