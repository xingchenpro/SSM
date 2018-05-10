package com.hly.spring.service;

import com.hly.spring.pojo.springBean.Role;
import com.hly.spring.pojo.springBean.User;

/**
 * @author :hly
 * @date :2018/5/10
 */
public interface RoleService {
    //@Component注入
    public void printRoleInfo(Role role);
    //@Autowired自动注入
    //public void printRoleInfo();
}
