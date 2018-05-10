package com.hly.spring.controller;

        import com.hly.spring.pojo.springBean.Role;
        import com.hly.spring.service.RoleService;
        import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author :hly
 * @date :2018/5/10
 */
public class RoleController {
    @Autowired
    private RoleService roleService;
    public void printRole(Role role){
        roleService.printRoleInfo(role);
    }

}
