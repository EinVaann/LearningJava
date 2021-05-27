package com.example.pbl.service;

import com.example.pbl.model.teacherInfo;
import com.example.pbl.repository.TeacherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherInfoService implements ITeacherInfoService {
    @Autowired
    private TeacherInfoRepository teacherInfoRepository;

    @Override
    public Iterable<teacherInfo> findAll() {
       return teacherInfoRepository.findAll();
    }

    @Override
    public Optional<teacherInfo> findById(Long id) {
        return teacherInfoRepository.findById(id);
    }

    @Override
    public teacherInfo save(teacherInfo teacherInfo) {
        return teacherInfoRepository.save(teacherInfo);
    }

    @Override
    public void remove(Long id) {
        teacherInfoRepository.deleteById(id);
    }

    @Override
    public List<teacherInfo> findBySubject(String subject)
    {
        return teacherInfoRepository.findBySubject(subject);
    }
}
