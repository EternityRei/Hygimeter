package com.example.hygimeter.repository;

import com.example.hygimeter.model.PlanParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanParametersRepository extends JpaRepository<PlanParameters, Integer> {
    // Custom methods if needed
}
