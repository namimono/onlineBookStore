package com.hx5847.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses");
        return new Class<?>[]{ConfigIOC.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getRootConfigClasses");
        return new Class<?>[]{ConfigMVC.class};
    }

    protected String[] getServletMappings() {
        System.out.println("getRootConfigClasses");
        return new String[]{"/"};
    }
}
