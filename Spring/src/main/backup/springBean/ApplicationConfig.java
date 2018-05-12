package com.hly.spring.pojo.springBean;

import com.hly.spring.ServiceImpl.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author :hly
 * @date :2018/5/10
 */

//@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class})
//@ComponentScan(basePackages = {"com.hly.spring.pojo.springBean"})
//@ComponentScan(basePackages = {"com.hly,spring.pojo.springBean","com.hly,spring,service"})
//@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound =  true)
//@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class},basePackages = {"com.hly,spring.pojo.springBean","com.hly,spring,service"})
public class ApplicationConfig {
    //spring能够解析属性占位符，没有这一句将不会解析${url}
    /*@Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
            return new PropertySourcesPlaceholderConfigurer();
    }*/
}
