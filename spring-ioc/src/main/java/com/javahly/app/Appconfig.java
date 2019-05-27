package com.javahly.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/16
 */
@Configuration
@ComponentScan("com.javahly")
//@ImportResource("classpath:application.xml")
@Profile("AppConfig1")
public class Appconfig {

}
