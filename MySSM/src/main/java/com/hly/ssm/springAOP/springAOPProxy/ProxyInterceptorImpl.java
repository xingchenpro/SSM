package com.hly.ssm.springAOP.springAOPProxy;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public class ProxyInterceptorImpl implements ProxyInterceptor {

    @Override
    public void before(Object object) {
        System.err.println("准备打印角色信息");
    }

    @Override
    public void after(Object object) {
        System.err.println("完成角色信息打印处理");
    }

    @Override
    public void afterReturning(Object object) {
        System.err.println("完成打印功能，一切正常");
    }

    @Override
    public void afterThrowing(Object object) {
        System.err.println("出现异常状况");
    }

}
