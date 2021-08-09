package com.project.pbl3.controller;

import com.project.pbl3.model.subjects;
import com.project.pbl3.model.teachers;
import com.project.pbl3.service.SubjectService;
import com.project.pbl3.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class teacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/teacher")
    public String getTeacherList(Model model, @RequestParam(name="subject",required = false) String subjectName,
                                 @RequestParam(name="sort",required = false) String sort){
        List<teachers> teacherList = new ArrayList<>();
        //System.out.println(subjectName);
        if(subjectName!=null && subjectName.compareTo("all-subject")!=0) {
            try {
                Integer subjectID = subjectService.getClassIdByName(subjectName);
                teacherList = teacherService.getTeacherBySubject(subjectID);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else teacherList = teacherService.findAll();

        if(sort!=null){
            System.out.println(sort.compareTo("id"));
            if(sort.compareTo("id")==0){
                teacherList.sort((t1, t2) -> {
                    if (t1.getID()>t2.getID()) return 1;
                    return -1;
                });
            }
            if(sort.compareTo("name")==0){
                teacherList.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
            }
        }
        //System.out.println(teacherList.size());
        model.addAttribute("teacherList",teacherList);
        return "teacher";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model){
        List<subjects> subjectsList= subjectService.findAll();
        model.addAttribute("subjectList",subjectsList);
        return "add-teacher";

    }

    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute("teachers") teachers teacherInfo){
        teacherService.save(teacherInfo);

        //System.out.println(teacherInfo.getEmail());
        return "redirect:/teacher";
    }
    @PostMapping("/edit-teacher")
    public String editTeacher(@ModelAttribute("teachers") teachers teacherInfo){
        teacherService.save(teacherInfo);
        //System.out.println(teacherInfo.getEmail());
        return "redirect:/teacher";
    }

    @GetMapping("/edit-teacher")
    public String editTeacher(Model model,@RequestParam int id){
        teachers teachers = teacherService.getTeacherById(id);
        model.addAttribute("teacherInfo",teachers);
        List<subjects> subjectsList= subjectService.findAll();
        model.addAttribute("subjectList",subjectsList);
        return "edit-teacher";
    }


    @RequestMapping("/delete-teacher")
    public String deleteTeacher(@RequestParam int id){
        teacherService.deleteTeacherById(id);
        return "redirect:/teacher";
    }
}
