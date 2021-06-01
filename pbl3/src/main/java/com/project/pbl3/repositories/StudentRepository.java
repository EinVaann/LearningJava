package com.project.pbl3.repositories;

import com.project.pbl3.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<students,Integer> {

}