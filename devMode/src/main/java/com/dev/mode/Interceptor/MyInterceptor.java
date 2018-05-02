package com.dev.mode.Interceptor;

import java.lang.reflect.Method;

/**
 * @author :hly
 * @date :2018/5/1
 */
//Interceptor的实现类
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前的逻辑");
        //不反射被代理对象的方法
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后的逻辑");
    }
}
