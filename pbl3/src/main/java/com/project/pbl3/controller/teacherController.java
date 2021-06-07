package com.project.pbl3.controller;

import com.project.pbl3.model.teachers;
import com.project.pbl3.service.SubjectService;
import com.project.pbl3.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println(subjectName);
        if(subjectName!=null && subjectName.compareTo("all-subject")!=0) {
            try {
                Integer subjectID = subjectService.getClassIdByName(subjectName);
                teacherList = teacherService.getTeacherBySubject(subjectID);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else teacherList = teacherService.findAll();

        if(sort!=null){
            if(sort.compareTo("Id")==0){
                teacherList.sort(new Comparator<teachers>(){
                    @Override
                    public int compare(teachers t1, teachers t2){
                        if (t1.getID()>t2.getID()) return 1;
                        return -1;
                    }
                });
            }
            if(sort.compareTo("Name")==0){
                teacherList.sort((t1,t2)   ->{
                        return t1.getName().compareTo(t2.getName());
                    }
                );
            }
        }
        //System.out.println(teacherList.size());
        model.addAttribute("teacherList",teacherList);
        return "teacher";
    }
}
