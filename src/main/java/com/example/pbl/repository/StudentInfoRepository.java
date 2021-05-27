package com.example.pbl.repository;


import com.example.pbl.model.studentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoRepository extends JpaRepository<studentInfo,Long> {
    @Query("select u from studentInfo u where u.class1 = ?1")
    List<studentInfo> findByClass(String class1);
}
