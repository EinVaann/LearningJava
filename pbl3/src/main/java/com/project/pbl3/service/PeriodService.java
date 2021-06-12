package com.project.pbl3.service;

import com.project.pbl3.model.periods;
import com.project.pbl3.repositories.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {
    @Autowired
    private PeriodRepository periodRepository;

    public List<periods> findAll() {
        List<periods> periods = periodRepository.findAll();
        return periods;
    }
    public periods findByID(Integer ID) throws Exception{
        List<periods> periodsList = periodRepository.findAll();
        for(periods p:periodsList){
            if(p.getID()==ID) return p;
        }
        throw new Exception("KHONG TIM THAY");
    }

    public periods save(periods period) {
        return periodRepository.save(period);
    }
}
