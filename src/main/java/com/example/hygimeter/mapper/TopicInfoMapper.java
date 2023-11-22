package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.TopicInfoDTO;
import com.example.hygimeter.model.TopicInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ThemeMapper.class)
public interface TopicInfoMapper {
    TopicInfoMapper INSTANCE = Mappers.getMapper(TopicInfoMapper.class);

    TopicInfo toTopicInfo(TopicInfoDTO topicInfoDTO);
    TopicInfoDTO toTopicInfoDTO(TopicInfo topicInfo);
}
