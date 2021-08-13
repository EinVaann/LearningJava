package com.project.pbl3.controller;

import com.project.pbl3.model.Period;
import com.project.pbl3.model.Subject;
import com.project.pbl3.repositories.PeriodRepository;
import com.project.pbl3.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class periodController {
    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/period")
    private String GetPeriod(Model model){
        List<Period> periodList = periodRepository.findAll();
        List<Subject> subjectList = subjectRepository.findAll();
        //System.out.print(periodsList.size());
        model.addAttribute("periodList", periodList);
        model.addAttribute("subjectList", subjectList);
        return "period";
    }

    @PostMapping("/edit-period")
    private String save(@ModelAttribute("periods") Period Period) throws Exception {
        Period newPeriod = periodRepository.getOne(Period.getID()+1);
        newPeriod.setPeriod(Period.getPeriod());
        periodRepository.save(newPeriod);
        return "redirect:/period";
    }

}
