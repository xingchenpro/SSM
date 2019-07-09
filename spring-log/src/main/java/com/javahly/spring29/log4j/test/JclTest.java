package com.javahly.spring29.log4j.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/7
 * @QQ :1136513099
 * @desc :
 */
public class JclTest {

    public static void main(String[] args){
        Log log = LogFactory.getLog("jcl");
        log.info("jcl");
    }
}
