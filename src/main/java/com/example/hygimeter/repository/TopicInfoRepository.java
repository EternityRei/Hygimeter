package com.example.hygimeter.repository;

import com.example.hygimeter.model.Theme;
import com.example.hygimeter.model.TopicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicInfoRepository extends JpaRepository<TopicInfo, Integer> {
    @Query("SELECT t FROM TopicInfo t JOIN t.themes theme WHERE theme IN :themes")
    List<TopicInfo> findAllByThemes(@Param("themes") List<Theme> themes);
    Optional<TopicInfo> findTopicInfoById(Integer id);
}
