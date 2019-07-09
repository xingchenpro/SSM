package com.hly.test;

import com.hly.config.AppConfig;
import com.hly.dao.IndexDao;
import com.hly.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/27
 * @QQ :1136513099
 * @desc :
 */
public class AspectTest {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = annotationConfigApplicationContext.getBean(IndexDao.class);
        for (int i = 0; i < 2; i++)
            indexDao.index("Hello");
    }

}
