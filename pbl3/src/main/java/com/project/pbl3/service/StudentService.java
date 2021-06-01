package com.project.pbl3.service;



import com.project.pbl3.model.students;
import com.project.pbl3.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<students> findByGrade(String grade) {
        List<students> studentsList = studentRepository.findAll();
        List<students> queryStudent = new ArrayList<>();
        for(students students: studentsList){
            System.out.println((students.getClassId()+" "+grade+" "+students.getClassId().contains(grade)));
            if(students.getClassId().contains(grade)) {
                queryStudent.add(students);
            }
        }
        System.out.println(queryStudent.size());
        return queryStudent;
    }
}
