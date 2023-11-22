package com.example.hygimeter.service;

import com.example.hygimeter.dto.ThemeDTO;
import com.example.hygimeter.dto.TopicInfoDTO;

import java.util.List;

public interface TopicInfoService {
    TopicInfoDTO createTopicInfo(TopicInfoDTO topicInfoDTO);
    TopicInfoDTO updateTopicInfo(TopicInfoDTO topicInfoDTO);
    void deleteTopicInfo(Integer id);
    TopicInfoDTO getTopicInfoById(Integer id);
    List<TopicInfoDTO> findAllTopics();
    List<TopicInfoDTO> findTopicsByTheme(List<ThemeDTO> themeDTO);
}
