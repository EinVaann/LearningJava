package com.project.pbl3.controller;

import com.project.pbl3.model.classes;
import com.project.pbl3.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class classController {
    @Autowired
    private ClassService classService;

    @GetMapping("/class-list")
    public String getClassList(Model model, @RequestParam(name="grade",required = false) String Grade){
        List<classes> classList = new ArrayList<>();
        if(Grade!=null && Grade.compareTo("all-grade")!=0) {
            try {
                classList = classService.getClassByGrade(Grade);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else classList = classService.findAll();
        model.addAttribute("classList",classList);
        return "classList";
    }

    @GetMapping("/add-class")
    public String addClass(){
        return "add-class";
    }

    @PostMapping("/add-class")
    public String addClass(@ModelAttribute("classes") classes info)
    {
        System.out.println(info.getID()+""+info.getName());
        classService.save(info);
        return "redirect:/class-list";
    }
    @PostMapping("/edit-class")
    public String editClass(@ModelAttribute("classes") classes classes){
        System.out.println(classes.getID()+""+classes.getName());
        classService.save(classes);
        return "redirect:/class-list";
    }

    @GetMapping("/edit-class")
    public String editTeacher(Model model,@RequestParam int id){
        classes classInfo = classService.getClassByID(id);
        model.addAttribute("classInfo",classInfo);
        return "edit-class";
    }

    @RequestMapping("/delete-class")
    public String deleteTeacher(@RequestParam int id){
       classService.deleteByID(id);
        return "redirect:/class-list";
    }
}
