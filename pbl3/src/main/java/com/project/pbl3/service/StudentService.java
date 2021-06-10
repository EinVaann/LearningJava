package com.project.pbl3.service;



import com.project.pbl3.model.classes;
import com.project.pbl3.model.students;
import com.project.pbl3.model.teachers;
import com.project.pbl3.repositories.ClassRepository;
import com.project.pbl3.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassService classService;
    public List<students> findByGrade(String grade) {
        List<students> studentsList = studentRepository.findAll();
        List<students> queryStudent = new ArrayList<>();
        List<classes> classList = classService.getClassByGrade(grade);
        for (classes class1:classList) {
            for (students students : studentsList) {
                if (students.getClassId()==class1.getID()) {
                    queryStudent.add(students);
                }
            }
        }

        System.out.println(queryStudent.size());
        return queryStudent;
    }
//    public List<students> findByKeyword (String keyword)
//    {
//
//    }
    public void save(students students){
    studentRepository.save(students);
}
    public students getStudentByID(Integer id){ return studentRepository.getOne(id);}
    public void deleteStudentByID(Integer id){ studentRepository.deleteById(id);}
    public List<students> findByKeyWord(String keyword)
    {
        return studentRepository.findByKeyword(keyword);
    }
}
