package com.dev.mode.CGLIB;


        import com.dev.mode.reflect.ReflectServiceImpl;
        import org.springframework.cglib.proxy.Enhancer;
        import org.springframework.cglib.proxy.MethodInterceptor;
        import org.springframework.cglib.proxy.MethodProxy;

        import java.lang.reflect.Method;

/**
 * @author :hly
 * @date :2018/5/1
 */

/**
 * JDK动态代理必须提供接口才能使用，在不提供接口的环境中，只能采取第三方技术Spring-AOP
 */
public class CglibProxyExample implements MethodInterceptor {

    /**
     * @param cls Class类
     * @return
     */
    public Object getProxy(Class cls) {
        //CGLIB enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型，设置超类的方法
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象实现MethodInterceptor 方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * @param proxy       代理对象
     * @param method      方法
     * @param args        方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     *                   System.err:1.实时输出2.使用log4j会保存到日志
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        //CGLIB反射调用真实对象方法
        Object result = methodProxy.invokeSuper(proxy, args);
        System.err.println("调用真实对象后");
        return result;
    }

    public void testCGLIBProxy(){
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        //getProxy方法产生代理对象
        ReflectServiceImpl obj = (ReflectServiceImpl)cglibProxyExample.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }

}
