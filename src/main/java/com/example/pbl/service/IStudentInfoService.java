package com.example.pbl.service;

import com.example.pbl.model.studentInfo;

import java.util.List;

public interface IStudentInfoService extends IGeneralService<studentInfo>{
    List<studentInfo> findByClass(String class1);
}
