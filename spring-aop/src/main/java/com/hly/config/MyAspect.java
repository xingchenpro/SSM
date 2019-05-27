package com.hly.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/10
 */
@Component
@Aspect//定义切面
public class MyAspect {


    //定义切点
    //找到切点的方法
    //pointCut 避免多次编写表达式
    //@Pointcut("args(String)")
    @Pointcut("this(com.hly.dao.IndexDao)")//this(指向代理对象类型)
    //@Pointcut("target(com.hly.dao.IndexDao)")//target(指向目标对象类型)
    //@Pointcut("execution( * *com.hly.dao.*.*(..))&&args(Integer)")
    //@Pointcut("execution(* com.hly.dao.*.*(..))")
    public void pointCut(){

    }
    //找到pointCut()
    //前置通知
    //给通知传递参数
    @Before("execution(* com.hly.dao.*.*(..))&& args(str)")
    public void before(String str) {
        System.out.println(str+":"+"advice-before...");
    }

    //后置通知
    @After("pointCut()")
    public void after() {
        System.out.println("advice-after...");
    }

    //返回通知，没有发生异常
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("advice-afterReturning...");
    }

    //异常通知，产生了异常
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("advice-afterThrowing...");
    }

    @Around("pointCut()")
    //ProceedingJoinPoint：Spring提供的参数
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            //反射切点的方法
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("advice-around...");
    }
}
