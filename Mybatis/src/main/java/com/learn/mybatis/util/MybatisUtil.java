package com.learn.mybatis.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author :hly
 * @date :2018/5/4
 */
public class MybatisUtil {

    private final static SqlSessionFactory sqlSessionFactory;

    static {
        //首先读取mybatis-config.xml，通过XML构建SqlSessionFactory
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Builder方法去创建SqlSessionFactory*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }




}
