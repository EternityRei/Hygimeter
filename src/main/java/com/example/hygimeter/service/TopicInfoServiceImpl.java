package com.example.hygimeter.service;

import com.example.hygimeter.dto.ThemeDTO;
import com.example.hygimeter.dto.TopicInfoDTO;
import com.example.hygimeter.mapper.ThemeMapper;
import com.example.hygimeter.mapper.TopicInfoMapper;
import com.example.hygimeter.model.Theme;
import com.example.hygimeter.model.TopicInfo;
import com.example.hygimeter.repository.TopicInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicInfoServiceImpl implements TopicInfoService{

    private final TopicInfoRepository topicInfoRepository;
    private final TopicInfoMapper topicInfoMapper;
    private final ThemeMapper themeMapper;

    @Override
    public TopicInfoDTO createTopicInfo(TopicInfoDTO topicInfoDTO) {
        TopicInfo topicInfo = topicInfoMapper.toTopicInfo(topicInfoDTO);
        return topicInfoMapper.toTopicInfoDTO(topicInfoRepository.save(topicInfo));
    }

    @Override
    public TopicInfoDTO updateTopicInfo(TopicInfoDTO topicInfoDTO) {
        TopicInfo topicInfo = topicInfoRepository.findById(topicInfoDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        TopicInfo newTopicInfo = topicInfoMapper.toTopicInfo(topicInfoDTO);
        topicInfo.setDescription(newTopicInfo.getDescription());
        topicInfo.setType(newTopicInfo.getType());
        topicInfo.setInfo(newTopicInfo.getInfo());
        topicInfo.setThemes(newTopicInfo.getThemes());
        topicInfo.setMicroclimatePlans(newTopicInfo.getMicroclimatePlans());

        return topicInfoMapper.toTopicInfoDTO(topicInfoRepository.save(topicInfo));
    }

    @Override
    public void deleteTopicInfo(Integer id) {
        if (!topicInfoRepository.existsById(id)) {
            throw new EntityNotFoundException("Humidity not found");
        }
        topicInfoRepository.deleteById(id);
    }

    @Override
    public TopicInfoDTO getTopicInfoById(Integer id) {
        TopicInfo topicInfo = topicInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found"));

        return topicInfoMapper.toTopicInfoDTO(topicInfo);
    }

    @Override
    public List<TopicInfoDTO> findAllTopics() {
        List<TopicInfo> topicInfos = topicInfoRepository.findAll();
        return topicInfoMapper.toTopicInfoDTOList(topicInfos);
    }

    @Override
    public List<TopicInfoDTO> findTopicsByTheme(List<ThemeDTO> themeDTO) {
        List<Theme> themes = themeMapper.toThemes(themeDTO);
        List<TopicInfo> topicInfos = topicInfoRepository.findAllByThemes(themes);
        return topicInfoMapper.toTopicInfoDTOList(topicInfos);
    }
}
