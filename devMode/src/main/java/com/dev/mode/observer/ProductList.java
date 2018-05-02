package com.dev.mode.observer;

/**
 * @author :hly
 * @date :2018/5/2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察的产品列表
 */
//观察者可以是多个，在java中继承Observable类
public class ProductList extends Observable {
    private List<String> productList = null;//产品列表
    private static  ProductList instance;//类唯一的实例

    /**
     * 获得唯一的实例
     * @return 产品列表唯一的实例
     */
    public static  ProductList getInstance(){
        if(instance ==null){
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观察者，电商接口
     * @param observer 观察者
     */
    //添加观察者
    public void addproductListObserver(Observer observer){
        this.addObserver(observer);//addObserver自带方法
    }
    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.err.println("产品列表增加了新的产品"+newProduct);
        this.setChanged();//自带方法，设置被观察对象发生变化，告诉观察者当前被观察者发生了变化
        //执行update
        this.notifyObservers(newProduct);//自带方法，通知观察者，并传递新产品
    }


}
