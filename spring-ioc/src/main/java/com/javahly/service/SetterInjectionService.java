package com.javahly.service;

import com.javahly.dao.SetterInjectionDao;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/26
 * @QQ :1136513099
 * @desc :
 */
public class SetterInjectionService {

    private SetterInjectionDao dao;

    public void service(){
        dao.test();
    }

    //依赖注入的方式之 Setter注入
    public void setSetterDao(SetterInjectionDao setterDao) {
        this.dao = setterDao;
    }
}
