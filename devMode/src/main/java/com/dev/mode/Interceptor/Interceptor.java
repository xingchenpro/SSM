package com.dev.mode.Interceptor;

import java.lang.reflect.Method;

/**
 * @author :hly
 * @date :2018/5/1
 */

/**
 * 这里定义了3个方法
 * proxy ：代理对象
 * target ：真实对象
 * method：方法
 * args ：运行方法参数
 */
public interface Interceptor {
    //true时，返回真实对象方法，false时，调用around方法
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    //反射真实对象或者around后调用after方法
    public void after(Object proxy, Object target, Method method, Object[] args);
}
