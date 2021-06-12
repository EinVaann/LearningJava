package com.project.pbl3.controller;

import com.project.pbl3.model.teachers;
import com.project.pbl3.model.users;
import com.project.pbl3.repositories.UserRepository;
import com.project.pbl3.service.PasswordEncoder;
import com.project.pbl3.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/register")
    public String register(@ModelAttribute("users")users users){
        teachers teachers = new teachers();
        users.setTeacherId(teachers.getID());
        users.setPassword(PasswordEncoder.getEncodePass(users.getPassword()));
        users.setEnable(true);
        userRepository.save(users);
        return "redirect:/";
    }
}
