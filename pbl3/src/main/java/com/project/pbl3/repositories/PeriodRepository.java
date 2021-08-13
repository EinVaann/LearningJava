package com.project.pbl3.repositories;

import com.project.pbl3.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Integer> {

   // @Query("UPDATE periods SET period  = period1.get(1).period where ID = 1")
  //  public void Update(@Param("period") );
}
