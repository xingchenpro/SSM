package com.javahly.spring29.log4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/7
 * @QQ :1136513099
 * @desc :
 */
public class Slf4jTest {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
        logger.info("slf4j");
    }
}
