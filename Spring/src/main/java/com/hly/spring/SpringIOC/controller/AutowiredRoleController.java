package com.hly.spring.SpringIOC.controller;

import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.service.AutowiredRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/12
 */
@Component
public class AutowiredRoleController {

    @Autowired
    //按名称注入
    @Qualifier("AutowiredRole1")
    AutowiredRoleService autowiredRoleService;

    public void printRole(){
        autowiredRoleService.printRoleInfo();
    }
}
