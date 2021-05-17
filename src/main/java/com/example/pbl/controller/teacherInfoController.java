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
public class teacherInfoController {
    @Autowired
    private TeacherInfoService teacherInfoService;

    private  TeacherInfoRepository teacherInfoRepository;

    public teacherInfoController(TeacherInfoRepository teacherInfoRepository)
     {
         this.teacherInfoRepository = teacherInfoRepository;
     }

    @PostMapping("/teacher")
    public String signUpSave(@ModelAttribute("teacherInfo") teacherInfo info) {
        //System.out.println(info.getEmail());
        teacherInfoService.save(info);
        return "greeting";

    }


    @GetMapping("/sign")
    public String getAllTeachers(Model model) {
        List<teacherInfo> teacherInfos = teacherInfoRepository.findAll();
        model.addAttribute("aaa",teacherInfos);
        return "Teacher";
    }

}
