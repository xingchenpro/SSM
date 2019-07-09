package com.javahly.setterBasedDependencyInjection.bean;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/8
 * @QQ :1136513099
 * @desc :
 */
public class ExampleBean {

    private int years;

    private String ultimateAnswer;

    //@Required 表明必须放在xml中
    @Required
    public void setUltimateAnswer(String ultimateAnswer) {
        this.ultimateAnswer = ultimateAnswer;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void test(){
        System.out.println(years+":"+ultimateAnswer);
    }
}
