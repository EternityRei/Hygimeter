package com.example.hygimeter.repository;

import com.example.hygimeter.model.PlanPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanPatternRepository extends JpaRepository<PlanPattern, Integer> {
    // Custom methods if needed
}
