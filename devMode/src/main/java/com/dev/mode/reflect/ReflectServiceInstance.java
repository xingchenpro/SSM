package com.dev.mode.reflect;

/**
 * @author :hly
 * @date :2018/5/1
 * <p>
 * 1.反射的优点就是只要配置就可以生成对象，可以解除程序的耦合度，比较灵活
 * 2.缺点就是运行比较慢
 */
/**
 * 1.反射的优点就是只要配置就可以生成对象，可以解除程序的耦合度，比较灵活
 * 2.缺点就是运行比较慢
 */

        import java.lang.reflect.InvocationTargetException;
        import java.lang.reflect.Method;

/**
 * 1.通过反射的方法去构建对象
 * 2.这段代码生成一个对象，然后将其返回。
 */
public class ReflectServiceInstance {
    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            /**
             * 1.Class.forName:初始化给定的类
             * 2.newInstance就是对象的实例化，默认调用五参数构造器
             */
            object = (ReflectServiceImpl) Class.forName("com.dev.mode.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 反射构建有参数的构造方法
     */
    public ReflectServiceImpl getInstance2() {
        ReflectServiceImpl object = null;

        try {
            object = (ReflectServiceImpl) Class.forName("com.dev.mode.reflect.ReflectServiceImpl").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 反射方法
     */
    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            /**
             * 多参数类型getMethod(method,class1,class2,class3)
             */
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            /**
             * 1.第一个对象target，确定用哪个对象调用方法
             * 2.等同于target.sayHello("张三");
             */
            returnObj = method.invoke(target, "张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    /**
     * 反射生成对象和反射调度方法
     *
     */
    public Object reflect() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.dev.mode.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object, "张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String agvs[]){
        System.out.println(new ReflectServiceInstance().reflect());
    }
}
