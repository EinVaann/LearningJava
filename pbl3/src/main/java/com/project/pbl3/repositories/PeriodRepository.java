package com.project.pbl3.repositories;
import java.util.List;
import com.project.pbl3.model.periods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@Repository
public interface PeriodRepository extends JpaRepository<periods,Integer> {

   // @Query("UPDATE periods SET period  = period1.get(1).period where ID = 1")
  //  public void Update(@Param("period") );
}
