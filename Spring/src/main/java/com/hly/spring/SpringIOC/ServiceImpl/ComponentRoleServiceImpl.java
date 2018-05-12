package com.hly.spring.SpringIOC.ServiceImpl;

import com.hly.spring.SpringIOC.pojo.BeanRole;
import com.hly.spring.SpringIOC.service.ComponentRoleService;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/12
 */
//实现类要装配
@Component
public class ComponentRoleServiceImpl implements ComponentRoleService {
    @Override
    public void printRoleInfo(BeanRole role) {
        System.out.println("ImplByComponent:"+role.getRoleName());
    }
}
