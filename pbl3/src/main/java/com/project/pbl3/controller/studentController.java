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

    @GetMapping("/class/{grade}")
    private String getStudentList(Model model, @PathVariable String grade,@RequestParam(name="sort",required = false) String sort, String keyword){
        if(keyword!=null)
        {
            model.addAttribute("studentList",studentService.findByKeyWord(keyword));
        }
        else {
            List<students> studentList = studentService.findByGrade(grade);
            if (sort != null) {
                System.out.println(sort.compareTo("id"));
                if (sort.compareTo("id") == 0) {
                    studentList.sort((t1, t2) -> {
                        if (t1.getID() > t2.getID()) return 1;
                        return -1;
                    });
                }
                if (sort.compareTo("name") == 0) {
                    studentList.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
                }
            }
            model.addAttribute("studentList", studentList);
        }
        model.addAttribute("grade", grade);
        return "studentList";
    }
    @GetMapping("/class/add-student")
    public String addStudent(Model model)
    {
        List<classes> classesList = classService.findAll();
        model.addAttribute("classesList", classesList);
        return "add-student";
    }

    @PostMapping("/class/add-student")
    public String addStudent(@ModelAttribute("students")students studentInfo){
        studentService.save(studentInfo);
        //System.out.println(teacherInfo.getEmail());
        return "redirect:/class";
    }
    @GetMapping("/class/edit-student")
    public String editStudent(Model model,@RequestParam int id){
        students students = studentService.getStudentByID(id);
        model.addAttribute("studentInfo",students);
        List<classes> classesList = classService.findAll();
        model.addAttribute("classesList",classesList);
        return "edit-student";
    }
    @PostMapping("/class/edit-student")
    public String editStudent(@ModelAttribute("students") students studentInfo){
        studentService.save(studentInfo);
        return "redirect:/class";
    }


    @RequestMapping("/class/delete-student")
    public String deleteTeacher(@RequestParam int id){
        studentService.deleteStudentByID(id);
        return "redirect:/class";
    }

}
