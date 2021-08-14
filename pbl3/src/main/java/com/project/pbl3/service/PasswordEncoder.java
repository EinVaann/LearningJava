package com.project.pbl3.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static String getEncodePass(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }
    public static Boolean match(String pass, String userPass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(pass,userPass);
    }
}
