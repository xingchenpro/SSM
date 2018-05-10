package com.hly.spring.ServiceImpl;

import com.hly.spring.pojo.springBean.Role;
import com.hly.spring.pojo.springBean.User;
import com.hly.spring.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/10
 */
//@Component表明他是Spring所需要的Bean
@Component()
@Primary
public class RoleServiceImpl implements RoleService {
    //SpringIOC定位所有的Bean后，这个字段需要按类型注入，IOC就会寻找资源，然后将其注入。
    //requiredIOC找不到对应的资源，没有异常抛出
    // @Autowired(required = false)
    // private Role role = null;
    //@Autowired自动注入
   /* @Override
    public void printRoleInfo() {
        System.out.print(role.getRoleName());
    }*/
    //@Autowired也可以方法配置
    /*@Autowired
    public void setRole(Role role){
        this.role=role;
    }*/
    @Override
    public void printRoleInfo(Role role) {
        System.out.print(role.getRoleName());

    }
}
