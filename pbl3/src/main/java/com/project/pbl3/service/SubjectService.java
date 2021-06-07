package com.project.pbl3.service;

import com.project.pbl3.model.subjects;
import com.project.pbl3.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public String getClassById(Integer subjectID) throws Exception{
        List<subjects> subjectsList = subjectRepository.findAll();
        for(subjects subjects: subjectsList){
            if(subjects.getID()==subjectID){
                return subjects.getName();
            }
        }
        throw new Exception("Can't find subject in database");
    }

    public Integer getClassIdByName(String subjectName) throws Exception{
        List<subjects> subjectsList = subjectRepository.findAll();
        for(subjects subjects: subjectsList){
            if(subjects.getName().contains(subjectName)){
                return subjects.getID();
            }
        }
        throw new Exception("Can't find subject in database");
    }
}
