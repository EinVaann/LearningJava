package com.example.pbl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pbl.model.teacherInfo;

@Repository
public interface TeacherInfoRepository extends JpaRepository<teacherInfo,Long> {
}
