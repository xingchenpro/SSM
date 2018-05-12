package com.learn.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author :hly
 * @date :2018/5/4
 */
public class SqlSessionFactoryUtil {

    private final static Class<SqlSessionFactoryUtil> LOCK =SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;
    //构造方法private,其他方法不能通过new来创建它
    private SqlSessionFactoryUtil(){
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        //防止在多线程中多次实例化SqlsessionFactory，保证其唯一性
        synchronized (LOCK){
            //不为空，说明已经被创建，直接返回
            if(sqlSessionFactory!=null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }
    //创建SQLSession对象
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory==null){
            //空的话就先执行这个方法
            getSqlSessionFactory();
        }
        //openSession()系统自带
        return sqlSessionFactory.openSession();
    }
}
