package com.hly.spring.SpringIOC.ServiceImpl;

import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.service.AutowiredRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/12
 */
@Component("AutowiredRole1")
//@Primary
public class AutowiredRoleServiceImpl1 implements AutowiredRoleService {
    //找不到，允许不注入，没有异常抛出
    @Autowired(required = true)
    private BeanRole beanRole =null;
    @Override
    public void printRoleInfo() {
        System.out.println("ImplByAutowired:"+beanRole.getRoleName());
    }
}
