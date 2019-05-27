package com.javahly.service.impl;

import com.javahly.dao.JavaBasedDao;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :
 */
@Component
public class JavaBasedServiceImpl implements JavaBasedDao {
    @Override
    public void test() {
        System.out.println("JavaBased Test......");
    }
}
