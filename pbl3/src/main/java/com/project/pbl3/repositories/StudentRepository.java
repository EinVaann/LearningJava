package com.project.pbl3.repositories;

import com.project.pbl3.model.Student;
import com.project.pbl3.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from students e where e.name like %:keyword% ",nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);

    /*@Query("SELECT s from students s where s not in (:studentsList) and s.name like :name")
    List<students> findNotIn(@Param("studentsList")List<students> studentsList,@Param("name")String name);*/

    @Query("SELECT s from Student s where s.classId in (select c.ID from Class c where c.name like :grade)" +
            "and s.name like :keyword")
    List<Student> findRequire(@Param("grade")String grade, @Param("keyword")String keyword);

    //@Query("SELECT s from students s where s.classId in (select c.ID from classes c where c.name like :grade)")
    //List<students> findByGrade(String grade);


    @Query("SELECT t FROM Student t where t.email like :email")
    List<Student> getStudentByEmail(@Param("email")String email);
}