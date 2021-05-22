package com.example.pbl.repository;


import com.example.pbl.model.studentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoRepository extends JpaRepository<studentInfo,Long> {
}
