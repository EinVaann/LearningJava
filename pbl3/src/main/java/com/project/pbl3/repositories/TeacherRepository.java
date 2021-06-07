package com.project.pbl3.repositories;

import com.project.pbl3.model.teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<teachers,Integer> {
}
