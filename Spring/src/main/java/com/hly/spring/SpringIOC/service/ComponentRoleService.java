package com.hly.spring.SpringIOC.service;

import com.hly.spring.SpringIOC.pojo.BeanRole;
import org.springframework.context.annotation.Bean;

/**
 * @author :hly
 * @date :2018/5/12
 */
public interface ComponentRoleService {
    //@Component注入
    public void printRoleInfo(BeanRole role);
}
