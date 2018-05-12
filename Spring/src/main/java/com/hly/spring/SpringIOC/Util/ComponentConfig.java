package com.hly.spring.SpringIOC.Util;

import com.hly.spring.SpringIOC.ServiceImpl.ComponentRoleServiceImpl;
import com.hly.spring.SpringIOC.pojo.BeanRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author :hly
 * @date :2018/5/12
 */
//@ComponentScan(basePackageClasses = {BeanRole.class, ComponentRoleServiceImpl.class})
@ComponentScan(basePackages = {"com.hly.spring.springIOC.pojo","com.hly.spring.springIOC"})
//@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound =  true)
//@ComponentScan(basePackageClasses = {BeanRole.class, ComponentRoleServiceImpl.class},basePackages = {"com.hly.spring.springIOC.pojo","com.hly.spring.springIOC.serviceImpl"})
public class ComponentConfig {
    //spring能够解析属性占位符，没有这一句将不会解析${url}
    @Bean
        public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
            return new PropertySourcesPlaceholderConfigurer();
    }
}
