package com.project.pbl3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/class").setViewName("class");
        registry.addViewController("/teacher").setViewName("teacher");
        registry.addViewController("/add-teacher").setViewName("add-teacher");
        registry.addViewController("/class/**").setViewName("studentList");
    }
}
