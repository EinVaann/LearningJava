package com.project.pbl3.controller;

import com.project.pbl3.model.Subject;
import com.project.pbl3.model.Teacher;
import com.project.pbl3.repositories.SubjectRepository;
import com.project.pbl3.repositories.TeacherRepository;
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
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/teacher-list")
    public String getTeacherList(Model model, @RequestParam(name="subject",required = false) String subjectName,
                                 @RequestParam(name="sort",required = false) String sort){
        List<Teacher> teacherList = new ArrayList<>();
        //System.out.println(subjectName);
        if(subjectName!=null && subjectName.compareTo("all-subject")!=0) {
            try {
                Integer subjectID = subjectRepository.getClassByName(subjectName).getID();
                teacherList = teacherRepository.getTeacherBySubject(subjectID);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else teacherList = teacherRepository.findAll();

        if(sort!=null){
            System.out.println(sort.compareTo("id"));
            if(sort.compareTo("id")==0){
                teacherList.sort((t1, t2) -> {
                    if (t1.getID()>t2.getID()) return 1;
                    return -1;
                });
            }
            if(sort.compareTo("name")==0){
                teacherList.sort(Comparator.comparing(Teacher::getName));
            }
        }
        model.addAttribute("teacherList",teacherList);
        return "teacher";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model){
        List<Subject> subjectList = subjectRepository.findAll();
        model.addAttribute("subjectList", subjectList);
        return "add-teacher";

    }

    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute("teachers") Teacher teacherInfo){
        teacherRepository.save(teacherInfo);

        //System.out.println(teacherInfo.getEmail());
        return "redirect:/teacher-list";
    }
    @PostMapping("/edit-teacher")
    public String editTeacher(@ModelAttribute("teachers") Teacher teacherInfo){
        teacherRepository.save(teacherInfo);
        //System.out.println(teacherInfo.getEmail());
        return "redirect:/teacher-list";
    }

    @GetMapping("/edit-teacher")
    public String editTeacher(Model model,@RequestParam int id){
        Teacher Teacher = teacherRepository.getOne(id);
        model.addAttribute("teacherInfo", Teacher);
        List<Subject> subjectList = subjectRepository.findAll();
        model.addAttribute("subjectList", subjectList);
        return "edit-teacher";
    }


    @RequestMapping("/delete-teacher")
    public String deleteTeacher(@RequestParam int id){
        teacherRepository.deleteById(id);
        return "redirect:/teacher-list";
    }
}
