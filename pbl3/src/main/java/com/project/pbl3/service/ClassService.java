package com.project.pbl3.service;

import com.project.pbl3.model.Class;
import com.project.pbl3.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<Class> findAll()
    {
        return classRepository.findAll();
    }
    public void save(Class info){
        classRepository.save(info);
    }
    public Class getClassByID(Integer id)
    {
        return classRepository.getOne(id);
    }
    public void deleteByID(Integer id)
    {
        classRepository.delete(classRepository.getOne(id));
    }

    public List<Class> getClassByGrade(String grade){
        List<Class> classList = classRepository.findAll();

        if(Integer.parseInt(grade)==0) return classList;
        else{
            List<Class> queryList = new ArrayList<>();
            for(Class class1:classList){
                if(class1.getName().substring(0,2).equals(grade)){
                    queryList.add(class1);
                }
            }
            return queryList;
        }
    }
}
