package com.project.pbl3.repositories;

import com.project.pbl3.model.classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ClassRepository extends JpaRepository<classes,Integer> {
}
