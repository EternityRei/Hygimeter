package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.model.MicroclimatePlan;
import com.example.hygimeter.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, MicroclimateMapper.class})
public interface MicroclimatePlanMapper {

    MicroclimatePlanMapper INSTANCE = Mappers.getMapper(MicroclimatePlanMapper.class);

    @Mapping(target = "user", source = "userId", qualifiedByName = "userIdToUser")
    MicroclimatePlan toMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO, @Context UserMapperContext context);
    @Mapping(target = "userId", source = "user.id")
    MicroclimatePlanDTO toMicroclimatePlanDTO(MicroclimatePlan microclimatePlan, @Context UserMapperContext context);

    List<MicroclimatePlan> toMicroclimatePlans(List<MicroclimatePlanDTO> microclimateDTOS);
    List<MicroclimatePlanDTO> toMicroclimateDTOS(List<MicroclimatePlan> microclimatePlans);

    @Named("userIdToUser")
    default User userIdToUser(Integer id, @Context UserMapperContext context) {
        UserDTO userDTO = context.getUserById(id);
        return UserMapper.INSTANCE.toUser(userDTO);
    }
}
