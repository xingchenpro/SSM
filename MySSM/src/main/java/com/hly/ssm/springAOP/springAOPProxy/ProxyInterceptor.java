package com.hly.ssm.springAOP.springAOPProxy;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public interface ProxyInterceptor {

    public void before(Object object);

    public void after(Object object);

    public void afterReturning(Object object);

    public void afterThrowing(Object object);
}
