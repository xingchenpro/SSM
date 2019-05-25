package com.javahly.service.impl;

import com.javahly.dao.IndexDao;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :
 */
@Component("daoImpl")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("test Setter Injection");
    }
}
