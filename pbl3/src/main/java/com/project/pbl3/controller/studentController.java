package com.project.pbl3.controller;


import com.project.pbl3.model.students;
import com.project.pbl3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/class/{grade}")
    private String getStudentList(Model model, @PathVariable String grade){
        List<students> studentList = studentService.findByGrade(grade);
        System.out.println(studentList.size());
        model.addAttribute("studentList",studentList);
        return "studentList";
    }

}
