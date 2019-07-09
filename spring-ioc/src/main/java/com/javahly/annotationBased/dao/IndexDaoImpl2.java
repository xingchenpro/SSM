package com.javahly.annotationBased.dao;

import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
@Component
public class IndexDaoImpl2 implements IndexDao {
    @Override
    public void test() {
        System.out.println("indexDaoImpl2");
    }
}
