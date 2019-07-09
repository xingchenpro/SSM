package com.javahly.spring29.log4j.test;

import com.javahly.spring29.log4j.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/7
 * @QQ :1136513099
 * @desc :
 */
public class Test {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("slf4j");

    }
}
