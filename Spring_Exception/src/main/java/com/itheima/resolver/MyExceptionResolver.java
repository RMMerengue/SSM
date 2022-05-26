package com.itheima.resolver;

import com.itheima.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    /*
        参数Exception：异常对象
        返回值ModelAndView：跳转到错误识图信息
     */

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        if(ex instanceof MyException){
            modelAndView.addObject("info","defination exception");
        }else if(ex instanceof ClassCastException){
            modelAndView.addObject("info", "Type convert exception");
        }

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
