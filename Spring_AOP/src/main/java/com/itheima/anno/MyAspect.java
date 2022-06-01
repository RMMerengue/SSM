package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("MyAspect.pointcut()")
    public void before(){
        System.out.println("before augmentation...");
    }

    public void afterReturning(){
        System.out.println("after augmentation...");
    }

    @Around("MyAspect.pointcut()")
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

    @After("MyAspect.pointcut()")
    public void after(){
        System.out.println("final augmentation");
    }

//    定义切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}

}
