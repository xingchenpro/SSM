package com.hly.test;

import com.hly.config.AppConfig;
import com.hly.dao.IndexDao;
import com.hly.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/10
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = annotationConfigApplicationContext.getBean(IndexDao.class);
        for (int i = 0; i < 2; i++)
            indexDao.index("Hello");
    }
}

//com.sun.proxy.$Proxy17 cannot be cast to com.hly.dao.IndexDaoImpl