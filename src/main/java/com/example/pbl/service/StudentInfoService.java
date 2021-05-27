package com.example.pbl.service;



import com.example.pbl.model.loginInfo;
import com.example.pbl.model.studentInfo;
import com.example.pbl.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentInfoService implements IStudentInfoService{
    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Override
    public Iterable<studentInfo> findAll() {
        return studentInfoRepository.findAll();
    }

    @Override
    public Optional<studentInfo> findById(Long id) {
        return studentInfoRepository.findById(id);
    }

    @Override
    public studentInfo save(studentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public void remove(Long id) {
      studentInfoRepository.deleteById(id);
    }

    @Override
    public List<studentInfo> findByClass(String class1) {
        return studentInfoRepository.findByClass(class1);
    }
}
