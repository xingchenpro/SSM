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
@Component("roleService2")
//@Primary
public class RoleServiceImpl2 implements RoleService {
   /* @Autowired(required = false)
    private Role role = null;*/

    //@Autowired自动注入
    /*@Override
    public void printRoleInfo() {
        System.out.print(role.getRoleNote());
    }*/
    @Override
    public void printRoleInfo(Role role) {
        System.out.print(role.getRoleNote());

    }

}
