package com.javahly.service;

import com.javahly.dao.AnnotationBasedDao;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AnnotationBasedService {

    //默认采用ByType装配方式，ByType没有找到根据ByName，没有找到报错。
    @Autowired
    private AnnotationBasedDao dao;

    public void service(){
        dao.test();
    }
}
