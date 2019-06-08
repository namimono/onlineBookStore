package com.hx5847.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ConfigIOC.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ConfigMVC.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
