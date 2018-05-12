package com.hly.spring.SpringIOC.Util;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author :hly
 * @date :2018/5/12
 */
@Component
public class PropertyBeanDataSource {
    @Value("${driver}")
    private String driver = null;
    @Value("${url}")
    private String url = null;
    @Value("${user}")
    private String user = null;
    @Value("${password}")
    private String password = null;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("user", user);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("url:"+url);
        return dataSource;

    }
}
