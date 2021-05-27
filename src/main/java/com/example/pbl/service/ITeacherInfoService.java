package com.example.pbl.service;
import com.example.pbl.model.teacherInfo;

import java.util.List;
import java.util.Optional;

public interface ITeacherInfoService extends IGeneralService<teacherInfo>{
    List<teacherInfo> findBySubject (String subject);
}
