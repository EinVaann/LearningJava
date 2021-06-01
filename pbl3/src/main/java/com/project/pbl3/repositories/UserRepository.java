package com.project.pbl3.repositories;


import com.project.pbl3.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<users,Integer> {

}
