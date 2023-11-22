package com.example.hygimeter.repository;

import com.example.hygimeter.model.TopicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicInfoRepository extends JpaRepository<TopicInfo, Integer> {
    // Custom methods if needed
}
