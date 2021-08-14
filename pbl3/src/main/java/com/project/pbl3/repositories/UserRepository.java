package com.project.pbl3.repositories;


import com.project.pbl3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select s from User s where s.username =?1")
    User findUserByName(String keyword);

    @Query("select s from User s where s.changePasswordToken =?1")
    User findUserByToken(String token);
}
