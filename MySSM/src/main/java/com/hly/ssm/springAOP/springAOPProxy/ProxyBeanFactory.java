package com.hly.ssm.springAOP.springAOPProxy;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj, ProxyInterceptor interceptor){
        return (T) ProxyBeanUtil.getBean(obj,interceptor);
    }


}
