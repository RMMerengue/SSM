package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"></property>
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name="userDao")//@Resource相当于@Qualifier+@Autowired
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        System.out.println("userDao");
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Service对象的销毁方法");
    }

}
