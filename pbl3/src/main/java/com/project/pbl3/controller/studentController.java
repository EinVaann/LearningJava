package com.project.pbl3.controller;


import com.project.pbl3.model.classes;
import com.project.pbl3.model.students;
import com.project.pbl3.model.subjects;
import com.project.pbl3.model.teachers;
import com.project.pbl3.service.ClassService;
import com.project.pbl3.service.StudentService;
import com.project.pbl3.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class studentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping("/student")
    private String getStudentList(Model model,@RequestParam(name="grade",required = false)String grade,
                                  @RequestParam(name="sort",required = false) String sort,
                                  @RequestParam(name="keyword",required = false)String keyword) {
        List<students> studentList = studentService.findRequire(grade,sort,keyword);
        model.addAttribute("studentList", studentList);
       // model.addAttribute("grade", grade);
        return "studentList";
    }

    @GetMapping("add-student")
    public String addStudent(Model model) {
        List<classes> classesList = classService.findAll();
        model.addAttribute("classesList", classesList);
        return "add-student";
    }

    @PostMapping("add-student")
    public String addStudent(@ModelAttribute("students") students studentInfo) {
        studentService.save(studentInfo);
        return "redirect:/student";
    }

    @GetMapping("edit-student")
    public String editStudent(Model model, @RequestParam int id) {
        students students = studentService.getStudentByID(id);
        model.addAttribute("studentInfo", students);
        List<classes> classesList = classService.findAll();
        model.addAttribute("classesList", classesList);
        return "edit-student";
    }

    @PostMapping("edit-student")
    public String editStudent(@ModelAttribute("students") students studentInfo) {
        studentService.save(studentInfo);
        return "redirect:/student";
    }


    @RequestMapping("delete-student")
    public String deleteTeacher(@RequestParam int id) {
        studentService.deleteStudentByID(id);
        return "redirect:/student";
    }

}
