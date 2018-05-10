package com.hly.spring.pojo.springBean;

import com.hly.spring.ServiceImpl.RoleServiceImpl;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :hly
 * @date :2018/5/10
 */

//@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class})
@ComponentScan(basePackages = {"com.hly,spring.pojo.springBean","com.hly,spring,service"})
//@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class},basePackages = {"com.hly,spring.pojo.springBean","com.hly,spring,service"})
public class ApplicationConfig {
}
