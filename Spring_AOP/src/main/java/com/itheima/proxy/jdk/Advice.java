package com.itheima.proxy.jdk;

public class Advice {
    public void before(){
        System.out.println("before augmentation");
    }

    public void after(){
        System.out.println("after augmentation");
    }
}
