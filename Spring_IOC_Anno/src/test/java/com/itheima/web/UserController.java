package com.itheima.web;

import com.itheima.config.SpringConfiuration;
import com.itheima.service.UserService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiuration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
