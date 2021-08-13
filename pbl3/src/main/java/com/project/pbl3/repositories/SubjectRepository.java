package com.project.pbl3.repositories;

import com.project.pbl3.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    @Query("select s from Subject s where s.name =:name")
    Subject getClassByName(@Param("name")String name);
}
