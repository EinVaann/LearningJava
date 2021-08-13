package com.project.pbl3.repositories;

import com.project.pbl3.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class,Integer> {

    @Query("select c from Class c where c.name like :grade")
    List<Class> getClassByGrade(@Param("grade")String grade);
}
