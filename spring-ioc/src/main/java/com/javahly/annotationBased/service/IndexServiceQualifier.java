package com.javahly.annotationBased.service;

import com.javahly.annotationBased.dao.IndexDao;
import com.javahly.annotationBased.dao.IndexDaoImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class IndexServiceQualifier {

    @Autowired
    //有多个实现类的情况
    @Qualifier("indexDaoImpl1")
    IndexDao indexDao;

    public void test(){
      indexDao.test();
    }


}
