package com.dev.mode.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * @author :hly
 * @date :2018/5/2
 */
public class TaoBaoObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String)product;
        System.err.println("发送新产品【"+newProduct+"】到淘宝商城");
    }
}
