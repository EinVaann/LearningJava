package com.project.pbl3.repositories;

import com.project.pbl3.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Query("SELECT t FROM Teacher t where t.subjectID = :subjectID")
    List<Teacher> getTeacherBySubject(@Param("subjectID")Integer subjectID);

    @Query("SELECT s from Teacher s where s.ID not in (select c.teacherId from User c)")
    List<Teacher> findTeachersByNonUser();
}
