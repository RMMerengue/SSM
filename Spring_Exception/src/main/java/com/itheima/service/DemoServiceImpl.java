package com.itheima.service;

import com.itheima.exception.MyException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DemoServiceImpl implements DemoService{
    public void show1(){
        System.out.println("Type convert exception...");
        Object str = "zhansan";
        Integer num = (Integer) str;
    }

    public void show2(){
        System.out.println("Divided by zero exception...");
        int i = 1/0;
    }

    public void show3() throws FileNotFoundException {
        System.out.println("File not found excetion...");
        InputStream in = new FileInputStream("C:/xxx/xxx/xxx.txt");
    }

    public void show4(){
        System.out.println("Null pointer exception");
        String str = null;
        str.length();
    }

    public void show5() throws MyException {
        System.out.println("Definition exception");
        throw new MyException();
    }
}
