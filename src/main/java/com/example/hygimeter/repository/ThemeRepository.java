package com.example.hygimeter.repository;

import com.example.hygimeter.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    // Custom methods if needed
}
