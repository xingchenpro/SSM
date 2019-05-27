package com.javahly.service;

import com.javahly.dao.ConstructorInjectionDao;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :
 */
public class ConstructorInjectionService {

    private ConstructorInjectionDao dao;

    public ConstructorInjectionService(ConstructorInjectionDao dao) {
        this.dao = dao;
    }

    public void service(){
        dao.test();
    }
}
