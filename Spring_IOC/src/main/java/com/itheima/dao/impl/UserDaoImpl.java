package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    private String userName;
    private int age;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl 创建...");
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }

    public void save() {
        System.out.println(userName + "===" + age);
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }
}
