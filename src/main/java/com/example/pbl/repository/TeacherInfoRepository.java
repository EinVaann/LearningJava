package com.example.pbl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.pbl.model.teacherInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherInfoRepository extends JpaRepository<teacherInfo,Long> {
    @Query("select u from teacherInfo u where u.subject = ?1")
    List<teacherInfo> findBySubject(String subject);
}
