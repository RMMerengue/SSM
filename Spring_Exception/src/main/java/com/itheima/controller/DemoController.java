package com.itheima.controller;

import com.itheima.exception.MyException;
import com.itheima.service.DemoService;
import com.itheima.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value="/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running");
        demoService.show1();
        return "index";
    }

}
