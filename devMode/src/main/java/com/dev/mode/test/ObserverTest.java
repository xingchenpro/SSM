package com.dev.mode.test;

import com.dev.mode.observer.JingDongObserver;
import com.dev.mode.observer.ProductList;
import com.dev.mode.observer.TaoBaoObserver;
import org.springframework.util.JdkIdGenerator;

/**
 * @author :hly
 * @date :2018/5/2
 */
public class ObserverTest {
    public static void main(String [] arvs){
        ProductList observable = ProductList.getInstance();
        JingDongObserver jingDongObserver = new JingDongObserver();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        observable.addObserver(jingDongObserver);
       // observable.addObserver(taoBaoObserver);
        observable.addproductListObserver(taoBaoObserver);
        observable.addProduct("新产品1");
        observable.addProduct("新产品2");

    }
}
