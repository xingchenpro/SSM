package com.hly.spring.SpringIOC.ServiceImpl;

import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.service.AutowiredRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/12
 */
@Component("AutowiredRole2")
public class AutowiredRoleServiceImpl2 implements AutowiredRoleService {

    @Autowired
    private BeanRole beanRole;
    @Override
    public void printRoleInfo() {
        System.out.println("ImplByAutowired:"+beanRole.getRoleNote());
    }
}
