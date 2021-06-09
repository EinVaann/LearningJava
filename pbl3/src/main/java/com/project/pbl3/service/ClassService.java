package com.project.pbl3.service;

import com.project.pbl3.model.classes;
import com.project.pbl3.model.teachers;
import com.project.pbl3.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<classes> findAll()
    {
        return classRepository.findAll();
    }
    public void save(classes class1)
    {
        classRepository.save(class1);
    }
    public classes getClassByID(Integer id)
    {
        return classRepository.getOne(id);
    }
    public void deleteByID(Integer id)
    {
        classRepository.delete(classRepository.getOne(id));
    }

    public List<classes> getClassByGrade(String grade){
        List<classes> classList = classRepository.findAll();

        if(Integer.parseInt(grade)==0) return classList;
        else{
            List<classes> queryList = new ArrayList<>();
            for(classes class1:classList){
                if(class1.getName().substring(0,2).equals(grade)){
                    queryList.add(class1);
                }
            }
            return queryList;
        }
    }
}
