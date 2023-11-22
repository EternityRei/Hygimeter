package com.example.hygimeter.repository;

import com.example.hygimeter.model.Theme;
import com.example.hygimeter.model.TopicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicInfoRepository extends JpaRepository<TopicInfo, Integer> {
    List<TopicInfo> findAllByThemes(List<Theme> themeList);
    Optional<TopicInfo> findTopicInfoById(Integer id);
}
