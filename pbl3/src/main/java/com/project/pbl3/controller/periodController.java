package com.project.pbl3.controller;

import com.project.pbl3.model.periods;
import com.project.pbl3.service.PeriodService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class periodController {
    @Autowired
    private PeriodService periodService;

    @GetMapping("/period")
    private String GetPeriod(Model model){
        List<periods> ListPeriods = periodService.findAll();
//        for (periods period: ListPeriods
//             ) {
//            period.setPeriod(3);
//            periodService.save(period);
//        }
        model.addAttribute("periods",ListPeriods);

        return "Period";
    }
//    @RequestMapping(value = "/save/", method = RequestMethod.POST)
//    public String controllerMethod(@RequestParam(value="myArray[]") List<String> Array){
//        System.out.println("My Array"+Array.get(0));
//        return "class";
//    }
}
