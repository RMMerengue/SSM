package com.itheima.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext sce) {
        return (ApplicationContext) sce.getAttribute("app");
    }
}
