package com.project.pbl3.service;

import com.project.pbl3.model.teachers;
import com.project.pbl3.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<teachers> getTeacherBySubject(Integer subjectID){
        List<teachers> teachersList = teacherRepository.findAll();
        if(subjectID==0) return teachersList;
        else{
            List<teachers> queryList = new ArrayList<>();
            for(teachers teachers:teachersList){
                if(teachers.getSubjectID()==subjectID){
                    queryList.add(teachers);
                }
            }
            return queryList;
        }
    }
    public List<teachers> findAll(){
        return teacherRepository.findAll();
    }

}
