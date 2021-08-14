package com.project.pbl3.controller;

import com.project.pbl3.model.Class;
import com.project.pbl3.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class classController {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/class-list")
    public String getClassList(Model model, @RequestParam(name="grade",required = false) String Grade){
        List<Class> classList = new ArrayList<>();
        if(Grade!=null && Grade.compareTo("all-grade")!=0) {
            try {
                classList = classRepository.getClassByGrade("%"+Grade+"%");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else classList = classRepository.findAll();
        model.addAttribute("classList",classList);
        return "class-list";
    }

    @GetMapping("/add-class")
    public String addClass(){
        return "add-class";
    }

    @PostMapping("/add-class")
    public String addClass(@ModelAttribute("classes") Class info)
    {
        //System.out.println(info.getID()+""+info.getName());
        List<Class> classes = classRepository.getClassByGrade(info.getName());
        if(classes==null) {
            classRepository.save(info);
            return "redirect:/class-list";
        }else return "/invalid";
    }
    @PostMapping("/edit-class")
    public String editClass(@ModelAttribute("classes") Class info){
        List<Class> classes = classRepository.getClassByGrade(info.getName());
        if(classes==null) {
            classRepository.save(info);
            return "redirect:/class-list";
        }else return "/invalid";
    }

    @GetMapping("/edit-class")
    public String editTeacher(Model model,@RequestParam int id){
        Class classInfo = classRepository.getOne(id);
        model.addAttribute("classInfo",classInfo);
        return "edit-class";
    }

    @RequestMapping("/delete-class")
    public String deleteTeacher(@RequestParam int id){
       classRepository.deleteById(id);
        return "redirect:/class-list";
    }
}
