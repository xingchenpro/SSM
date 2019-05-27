package com.hly.test;

import com.hly.config.AppConfig;
import com.hly.dao.IndexDao;
import com.hly.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/10
 */
public class JDKProxyTest {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = (IndexDao) annotationConfigApplicationContext.getBean("indexDaoImpl");//indexDaoImpl是目标对象，这里的indexDao已变成代理对象
        //IndexDaoProxyObject是代理对象，IndexDaoProxyObject instanceof  indexDao|| Proxy
        //代理对象IndexDaoProxyObject不等于目标对象indexDaoImpl，他们都等于共同的接口IndexDao
        System.out.println(indexDao instanceof IndexDaoImpl);
        //IndexDao indexDao = annotationConfigApplicationContext.getBean(IndexDao.class);
        for (int i = 0; i < 2; i++)
        indexDao.index("Hello");

        /*Class<?>[] interfaces = new Class[]{IndexDao.class};
        byte bytes [] = ProxyGenerator.generateProxyClass("IndexDaoProxyObject",interfaces);//IndexDaoProxyObject是代理对象
        File file = new File("d:\\Test.class");
        FileOutputStream fw = new FileOutputStream(file);
        fw.write(bytes);
        fw.flush();
        fw.close();*/
    }
}

//com.sun.proxy.$Proxy17 cannot be cast to com.hly.dao.IndexDaoImpl