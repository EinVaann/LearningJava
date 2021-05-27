package com.example.pbl.controller;

import com.example.pbl.model.studentInfo;
import com.example.pbl.repository.StudentInfoRepository;
import com.example.pbl.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class studentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;
    private StudentInfoRepository studentInfoRepository;
    public studentInfoController(StudentInfoRepository studentInfoRepository)
    {
        this.studentInfoRepository = studentInfoRepository;
    }
    @GetMapping("/students")
    public String getAllStudent(@ModelAttribute("studentInfo") studentInfo info, Model model) {
        List<studentInfo> studentInfos = studentInfoRepository.findAll();
        //List<studentInfo> studentInfos = studentInfoRepository.findByClass("10b1");
        model.addAttribute("bbb",studentInfos);
        return "Student";
    }
    @PostMapping("/students")
    public String studentInfoSave(@ModelAttribute("studentInfo") studentInfo info)
    {
        studentInfoRepository.save(info);
        return "greeting";
    }


    @GetMapping("/10b1")
    public  String getAll10b1(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
       List<studentInfo> studentInfos = studentInfoRepository.findByClass("10b1");
       model.addAttribute("class10b1",studentInfos);
       return "Student-ten";
    }
    @GetMapping("/10b2")
    public  String getAll10b2(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("10b2");
        model.addAttribute("class10b2",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/10b3")
    public  String getAll10b3(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("10b3");
        model.addAttribute("class10b3",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/11b1")
    public  String getAll11b1(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("11b1");
        model.addAttribute("class11b1",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/11b2")
    public  String getAll11b2(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("11b2");
        model.addAttribute("class11b2",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/11b3")
    public  String getAll11b3(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("11b3");
        model.addAttribute("class11b3",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/12b1")
    public  String getAll12b1(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("12b1");
        model.addAttribute("class12b1",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/12b2")
    public  String getAll12b2(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("12b2");
        model.addAttribute("class12b2",studentInfos);
        return "Student-ten";
    }
    @GetMapping("/12b3")
    public  String getAll12b3(@ModelAttribute("studentInfo") studentInfo info,Model model)
    {
        List<studentInfo> studentInfos = studentInfoRepository.findByClass("12b3");
        model.addAttribute("class12b3",studentInfos);
        return "Student-ten";
    }

    @GetMapping("/Class")
    public  String getAllClass(Model model)
    {
        return "Class";
    }
    @GetMapping("/grade-10")
    public  String getAllClass10(Model model)
    {
        return "grade-ten";
    }
    @GetMapping("/grade-11")
    public  String getAllClass11(Model model)
    {
        return "grade-eleven";
    }
    @GetMapping("/grade-12")
    public  String getAllClass12(Model model)
    {
        return "grade-twelve";
    }

}
