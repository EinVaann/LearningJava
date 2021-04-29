package com.example.pbl.repository;

import com.example.pbl.model.loginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends JpaRepository<loginInfo,Long> {
}
