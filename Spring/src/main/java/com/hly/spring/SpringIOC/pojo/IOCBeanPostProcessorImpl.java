package com.hly.spring.SpringIOC.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author :hly
 * @date :2018/5/9
 */
public class IOCBeanPostProcessorImpl implements BeanPostProcessor {
    //bean.getClass().getSimpleName()
    //Bean装配了这个方法就会调用这个方法
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【" + bean.getClass().getSimpleName() + "】" + beanName + "开始实例化");
        return bean;
    }

    //实现了BeanPostProcessor接口的postProcessAfterInitialization方法的完成了调用，Bean就存在于SpringIOC的容器中了，使用者就可以获取Bean的服务
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【" + bean.getClass().getSimpleName() + "】" + beanName + "实例化完成");
        return bean;
    }
}
