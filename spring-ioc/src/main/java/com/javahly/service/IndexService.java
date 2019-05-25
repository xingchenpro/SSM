package com.javahly.service;

import com.javahly.dao.IndexDao;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :
 */
public class IndexService {
    private String str;
    //Service依赖了Dao
    private IndexDao dao;

    public void service(){
        System.out.println(str);
        dao.test();
    }

    //Setter注入
    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
