package com.example.hygimeter.repository;

import com.example.hygimeter.model.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<Humidity, Integer> {
    // Custom methods if needed
}
