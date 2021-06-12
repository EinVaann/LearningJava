package com.project.pbl3.service;



import com.project.pbl3.model.classes;
import com.project.pbl3.model.students;
import com.project.pbl3.model.teachers;
import com.project.pbl3.repositories.ClassRepository;
import com.project.pbl3.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassService classService;


    public List<students> findByGrade(String grade) {
        List<students> studentsList = studentRepository.findAll();
        if(grade.compareTo("all")==0) return studentsList;
        List<students> queryStudent = new ArrayList<>();
            for (students students : studentsList) {
                if (classService.getClassByID(students.getClassId()).getName().contains(grade)) {
                    queryStudent.add(students);
                }
            }

        //System.out.println(queryStudent.size());
        return queryStudent;
    }
    public void save(students students){
    studentRepository.save(students);
}
    public students getStudentByID(Integer id){ return studentRepository.getOne(id);}
    public void deleteStudentByID(Integer id){ studentRepository.deleteById(id);}
    public List<students> findByKeyWord(String keyword)
    {
        return studentRepository.findByKeyword(keyword);
    }

    public List<students> findAll() {return studentRepository.findAll(); }

    public List<students> findRequire(String grade,String sort,String keyword){
        List<students> studentsList = new ArrayList<>();
        List<students> queryList = new ArrayList<>();
        if(grade!=null) studentsList = findByGrade(grade);
        else studentsList = findAll();
        if(keyword!=null){
            for(students s:studentsList){
                if(s.getName().contains(keyword)){
                    queryList.add(s);
                }
            }
        }else queryList=studentsList;
        sort(sort,queryList);
        return queryList;
    }

    public List<students> sort(String sort,List<students> studentsList){
        if(sort!=null){
            System.out.println(sort.compareTo("id"));
            if(sort.compareTo("id")==0){
                studentsList.sort((t1, t2) -> {
                    if (t1.getID()>t2.getID()) return 1;
                    return -1;
                });
            }
            if(sort.compareTo("name")==0)
                studentsList.sort(Comparator.comparing(students::getName));
            }
        return studentsList;
    }
}
