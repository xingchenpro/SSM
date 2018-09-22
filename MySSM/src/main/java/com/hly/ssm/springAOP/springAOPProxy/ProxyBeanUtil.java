package com.hly.ssm.springAOP.springAOPProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/22
 */
public class ProxyBeanUtil implements InvocationHandler {

    //被代理的对象
    private Object object;
    //拦截器
    private ProxyInterceptor interceptor = null;

    /**
     * 获取动态代理的对象
     * @param object 被代理的对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object object,ProxyInterceptor interceptor){

        //使用当前类作为代理方法，此时被代理对象执行方法的时候，会进入当前类的invoke方法里
        ProxyBeanUtil _this = new ProxyBeanUtil();
        //保存被代理对象
        _this.object = object;
        //保存拦截器1
        _this.interceptor = interceptor;
        //生成代理对象，并绑定代理方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),_this);

    }

    /**
     * 代理方法
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 参数
     * @return 方法返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        Object retobj = null;
        //是否产生异常
        boolean exception = false;
        interceptor.before(object);
        try {
            //反射原有方法
            retobj = method.invoke(object,args);

        } catch (Exception e) {
            //e.printStackTrace();
            exception = true;
        } finally {
            interceptor.after(object);
        }
        if(exception){
            interceptor.afterThrowing(object);
        }else{
            interceptor.afterReturning(object);

        }
        return retobj;
    }

}
