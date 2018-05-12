package com.hly.spring.SpringIOC.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author :hly
 * @date :2018/5/12
 */
public class BeanComplexAssemble {
    private Long id;
    private List<String> list;
    private Map<String,String> map;
    //主要用于读取Java的配置文件，各种语言都有自己所支持的配置文件，配置文件中很多变量是经常改变的，这样做也是为了方便用户，让用户能够脱离程序本身去修改相关的变量设置
    private Properties props;
    private Set<String> set;
    private String[]arrays;
    private List<BeanUser> listBeanUser;

    public List<BeanUser> getListBeanUser() {
        return listBeanUser;
    }

    public void setListBeanUser(List<BeanUser> listBeanUser) {
        this.listBeanUser = listBeanUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getArrays() {
        return arrays;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }
}
