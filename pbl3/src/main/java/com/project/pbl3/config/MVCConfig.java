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
        registry.addViewController("/teacher").setViewName("teacher");
        registry.addViewController("/add-teacher").setViewName("add-teacher");
        registry.addViewController("/edit-teacher").setViewName("edit-teacher");
        registry.addViewController("/student").setViewName("studentList");
        registry.addViewController("/period").setViewName("Period");
        registry.addViewController("/class-list").setViewName("classList");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/register_success").setViewName("register_success");
        registry.addViewController("/users-list").setViewName("users-list");
    }
}
