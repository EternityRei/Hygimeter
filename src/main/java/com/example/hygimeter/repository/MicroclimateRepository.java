package com.example.hygimeter.repository;

import com.example.hygimeter.model.Microclimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroclimateRepository extends JpaRepository<Microclimate, Integer> {
    // Custom methods if needed
}
