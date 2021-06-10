package com.project.pbl3.repositories;

import com.project.pbl3.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<students,Integer> {
    @Query(value = "select * from students e where e.name like %:keyword% ",nativeQuery = true)
    List<students> findByKeyword(@Param("keyword") String keyword);

}