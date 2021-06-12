package com.project.pbl3.controller;

import com.project.pbl3.model.periods;
import com.project.pbl3.model.subjects;
import com.project.pbl3.service.PeriodService;
import com.project.pbl3.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class periodController {
    @Autowired
    private PeriodService periodService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/period")
    private String GetPeriod(Model model){
        List<periods> periodsList = periodService.findAll();
        List<subjects> subjectsList = subjectService.findAll();
        //System.out.print(periodsList.size());
        model.addAttribute("periodList",periodsList);
        model.addAttribute("subjectList",subjectsList);
        return "Period";
    }

    @PostMapping("/edit-period")
    private String save(@ModelAttribute("periods") periods periods) throws Exception {
        periods newPeriod = periodService.findByID(periods.getID()+1);
        newPeriod.setPeriod(periods.getPeriod());
        periodService.save(newPeriod);
        return "redirect:/period";
    }

}
