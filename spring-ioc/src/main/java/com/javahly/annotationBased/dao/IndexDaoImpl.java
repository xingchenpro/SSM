package com.javahly.annotationBased.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/8
 * @QQ :1136513099
 * @desc :
 */
@Repository
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {

    @Override
    public void test() {
        System.out.println("DAO");
    }
}
