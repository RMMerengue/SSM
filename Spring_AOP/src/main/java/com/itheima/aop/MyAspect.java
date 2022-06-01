package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("before augmentation...");
    }

    public void afterReturning(){
        System.out.println("after augmentation...");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before augmentation...");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("around after augmentation...");
        return proceed;
    }

    public void afterthrow(){
        System.out.println("exception augmentation");
    }

    public void after(){
        System.out.println("final augmentation");
    }

}
