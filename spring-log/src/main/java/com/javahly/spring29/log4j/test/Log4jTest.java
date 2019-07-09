package com.javahly.spring29.log4j.test;

import org.apache.log4j.Logger;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/7
 * @QQ :1136513099
 * @desc :
 */
public class Log4jTest {


    public static void main(String[] args){
        Logger logger = Logger.getLogger("log4jTest");
        logger.info("log4j");

    }
}
