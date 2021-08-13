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
        registry.addViewController("/teacher-list").setViewName("teacher");
        registry.addViewController("/add-teacher").setViewName("add-teacher");
        registry.addViewController("/edit-teacher").setViewName("edit-teacher");
        registry.addViewController("/student-list").setViewName("student-list");
        registry.addViewController("/period").setViewName("period");
        registry.addViewController("/class-list").setViewName("class-list");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/users-list").setViewName("users");
        registry.addViewController("/access_denied").setViewName("access-denied");
        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/link-user").setViewName("link-user");
    }
}
