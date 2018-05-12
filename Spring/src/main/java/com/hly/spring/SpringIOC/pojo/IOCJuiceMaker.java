
package com.hly.spring.SpringIOC.pojo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author :hly
 * @date :2018/5/9
 */
//实现了这些接口，初始化bean就会实现以下方法
public class IOCJuiceMaker implements BeanNameAware ,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{

    private  String beverageShop = null;
    private IOCSource source;
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"执行自定义初始化方法");
    }

    public void myDestroy(){
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"执行自定义销毁方法");
    }


    public String makeJuice(){
        return "这是一杯由"+beverageShop+"饮品店提供的"+source.getSize()+" "+source.getSugar()+" "+source.getFruit()+" 果汁";
    }
    public String getBeverageShop() {
        return beverageShop;
    }
    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }
    public IOCSource getIOCSource() {
        return source;
    }
    public void setIOCSource(IOCSource source) {
        this.source = source;
    }
    //以下为生命周期方法，按顺序
    @Override
    public void setBeanName(String s) {
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"调用BeanNameAware接口的setBeanFactory方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"调用setApplicationContext接口的setApplicationContext方法");
    }
    //这里是postProcessBeforeInitialization，在BeanPostProcessImpl方法里

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】"+"调用InitializingBean接口的afterPropertiesSet方法");
    }
    //这里是postProcessAfterInitialization，在BeanPostProcessImpl方法里
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy方法");
    }
    //之后是自定义销毁方法




}
