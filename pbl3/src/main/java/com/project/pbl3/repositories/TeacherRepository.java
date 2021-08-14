package com.project.pbl3.repositories;

import com.project.pbl3.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Query("SELECT t FROM Teacher t where t.subjectID = :subjectID and t.ID!=0")
    List<Teacher> getTeacherBySubject(@Param("subjectID")Integer subjectID);

    @Query("SELECT t from Teacher t  where t.ID not in (select c.teacherId from User c where c.id!=1) ")
    List<Teacher> findTeachersByNonUser();

    @Query("SELECT t FROM Teacher t where t.ID!=0")
    List<Teacher> findAllExc();
}
