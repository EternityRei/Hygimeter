package com.example.hygimeter.service;

import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.mapper.MicroclimatePlanMapper;
import com.example.hygimeter.mapper.UserMapper;
import com.example.hygimeter.mapper.UserMapperContext;
import com.example.hygimeter.model.MicroclimatePlan;
import com.example.hygimeter.model.User;
import com.example.hygimeter.repository.MicroclimatePlanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MicroclimatePlanServiceImpl implements MicroclimatePlanService{

    private final MicroclimatePlanRepository microclimatePlanRepository;
    private final MicroclimatePlanMapper microclimatePlanMapper;
    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public MicroclimatePlanDTO createMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO) {
        UserMapperContext context = new UserMapperContext(userService);
        MicroclimatePlan microclimatePlan = microclimatePlanMapper.toMicroclimatePlan(microclimatePlanDTO, context);
        return microclimatePlanMapper.toMicroclimatePlanDTO(microclimatePlanRepository.save(microclimatePlan), context);
    }

    @Override
    public MicroclimatePlanDTO updateMicroclimatePlan(Integer microclimateId, MicroclimatePlanDTO microclimatePlanDTO) {
        UserMapperContext context = new UserMapperContext(userService);
        MicroclimatePlan microclimatePlan = microclimatePlanRepository.findById(microclimateId)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate Plan not found"));

        MicroclimatePlan newMicroclimatePlan = microclimatePlanMapper.toMicroclimatePlan(microclimatePlanDTO, context);
        microclimatePlan.setInitialMicroclimate(newMicroclimatePlan.getInitialMicroclimate());
        microclimatePlan.setGoalMicroclimate(newMicroclimatePlan.getGoalMicroclimate());
        microclimatePlan.setUser(newMicroclimatePlan.getUser());
        microclimatePlan.setDevice(newMicroclimatePlan.getDevice());

        return microclimatePlanMapper.toMicroclimatePlanDTO(microclimatePlanRepository.save(microclimatePlan), context);
    }

    @Override
    public void deleteMicroclimatePlan(Integer id) {
        MicroclimatePlan microclimatePlan = microclimatePlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate Plan not found"));

        microclimatePlanRepository.deleteById(microclimatePlan.getId());
    }

    @Override
    public MicroclimatePlanDTO getMicroclimatePlanById(Integer id) {
        UserMapperContext context = new UserMapperContext(userService);
        MicroclimatePlan microclimatePlan = microclimatePlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate Plan not found"));

        return microclimatePlanMapper.toMicroclimatePlanDTO(microclimatePlan, context);
    }

    @Override
    public List<MicroclimatePlanDTO> findAllMicroclimatePlans() {
        List<MicroclimatePlan> microclimatePlans = microclimatePlanRepository.findAll();
        return microclimatePlanMapper.toMicroclimateDTOS(microclimatePlans);
    }

    @Override
    public List<MicroclimatePlanDTO> findMicroclimatePlansByUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        List<MicroclimatePlan> microclimatePlans = microclimatePlanRepository.findMicroclimatePlansByUser(user);
        return microclimatePlanMapper.toMicroclimateDTOS(microclimatePlans);
    }

    @Override
    public MicroclimatePlanDTO findMicroclimatePlanByUser(UserDTO userDTO) {
        UserMapperContext context = new UserMapperContext(userService);
        User user = userMapper.toUser(userDTO);
        MicroclimatePlan microclimatePlan = microclimatePlanRepository.findMicroclimatePlanByUser(user);
        return microclimatePlanMapper.toMicroclimatePlanDTO(microclimatePlan, context);
    }

    @Override
    public MicroclimatePlanDTO findMicroclimatePlanById(Integer id) {
        UserMapperContext context = new UserMapperContext(userService);
        MicroclimatePlan microclimatePlan = microclimatePlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate Plan not found"));

        return microclimatePlanMapper.toMicroclimatePlanDTO(microclimatePlan, context);
    }
}
