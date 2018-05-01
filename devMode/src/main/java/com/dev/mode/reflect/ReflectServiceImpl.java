package com.dev.mode.reflect;

/**
 * @author :hly
 * @date :2018/5/1
 */

/**
 * @param：通过反射配置信息构建对象
 */
public class ReflectServiceImpl {
    private String name ;

    public ReflectServiceImpl(String name) {
        this.name = name;
    }
    public ReflectServiceImpl() {
    }

    public void sayHello(String name){
        System.out.println("Hello"+" "+name);
    }
}
