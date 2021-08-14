package com.project.pbl3.controller;


import com.project.pbl3.model.Class;
import com.project.pbl3.model.Student;
import com.project.pbl3.model.Teacher;
import com.project.pbl3.repositories.ClassRepository;
import com.project.pbl3.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@Controller
public class studentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/student-list")
    private String getStudentList(Model model,@RequestParam(name="grade",required = false)String grade,
                                  @RequestParam(name="sort",required = false) String sort,
                                  @RequestParam(name="keyword",required = false)String keyword) {
        if(grade==null || grade.compareTo("all")==0) grade="";
        if(keyword==null) keyword="";
        List<Student> studentList = studentRepository.findRequire("%"+grade+"%","%"+keyword+"%");
        if(sort!=null){
            System.out.println(sort.compareTo("id"));
            if(sort.compareTo("id")==0){
                studentList.sort((t1, t2) -> {
                    if (t1.getID()>t2.getID()) return 1;
                    return -1;
                });
            }
            if(sort.compareTo("name")==0)
                studentList.sort(Comparator.comparing(Student::getName));
        }
        model.addAttribute("studentList", studentList);
       // model.addAttribute("grade", grade);
        return "student-list";
    }

    @GetMapping("add-student")
    public String addStudent(Model model) {
        List<Class> classList = classRepository.findAll();
        model.addAttribute("classesList", classList);
        return "add-student";
    }

    @PostMapping("add-student")
    public String addStudent(@ModelAttribute("students") Student studentInfo) {
        List<Student> students = studentRepository.getStudentByEmail(studentInfo.getEmail());
        if(students.size()==0) {
            studentRepository.save(studentInfo);

            //System.out.println(teacherInfo.getEmail());
            return "redirect:/teacher-list";
        }else return "/invalid";
    }

    @GetMapping("edit-student")
    public String editStudent(Model model, @RequestParam int id) {
        Student Student = studentRepository.getOne(id);
        model.addAttribute("studentInfo", Student);
        List<Class> classList = classRepository.findAll();
        model.addAttribute("classesList", classList);
        return "edit-student";
    }

    @PostMapping("edit-student")
    public String editStudent(@ModelAttribute("students") Student studentInfo) {
        List<Student> students = studentRepository.getStudentByEmail(studentInfo.getEmail());
        if(students.size()==0) {
            studentRepository.save(studentInfo);

            //System.out.println(teacherInfo.getEmail());
            return "redirect:/teacher-list";
        }else return "/invalid";
    }


    @RequestMapping("delete-student")
    public String deleteTeacher(@RequestParam int id) {
        studentRepository.deleteById(id);
        return "redirect:/student-list";
    }

}
