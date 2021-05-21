package com.example.pbl.controller;


import com.example.pbl.model.loginInfo;
import com.example.pbl.model.teacherInfo;
import com.example.pbl.repository.LoginInfoRepository;
import com.example.pbl.repository.TeacherInfoRepository;
import com.example.pbl.service.LoginInfoService;

import com.example.pbl.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class loginInfoController {
    @Autowired
    private LoginInfoService loginInfoService;

    @PostMapping("/signup")
    public String signUpSave(@ModelAttribute("loginInfo") loginInfo info) {
        //System.out.println(info.getEmail());
        loginInfoService.save(info);
        return "redirect:/";

    }

    @PostMapping("/signin")
    public String signInCheck(@ModelAttribute("loginInfo") loginInfo info,Model model) {
        //String s = info.getEmail();
        Iterable<loginInfo> infoList = loginInfoService.findAll();
        for (loginInfo i : infoList) {
            //String s2 = i.getEmail();
            //.out.printf("'%s' '%s' %d %n", s2, s,s.compareTo(s2));
            if (i.getEmail().compareTo(info.getEmail()) == 0 && i.getPassword().compareTo(info.getPassword()) == 0) {
                // System.out.println("found you");
                // return "/greeting";
                return "getTeacher";
            }
        }
        return "redirect:/";
    }


    @GetMapping("/t")
    public String t(Model model) {
        return "greeting";
    }

}

