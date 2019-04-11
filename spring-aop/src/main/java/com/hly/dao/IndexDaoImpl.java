package com.hly.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/10
 */
@Component
public class IndexDaoImpl implements IndexDao {

    @Override
    public void index(String str) {
        System.out.println(str);
    }




}
