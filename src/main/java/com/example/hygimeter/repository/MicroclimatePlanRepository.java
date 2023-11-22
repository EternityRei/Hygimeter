package com.example.hygimeter.repository;

import com.example.hygimeter.model.MicroclimatePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroclimatePlanRepository extends JpaRepository<MicroclimatePlan, Integer> {
    // Custom methods if needed
}
