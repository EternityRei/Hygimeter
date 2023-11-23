package com.example.hygimeter.repository;

import com.example.hygimeter.model.MicroclimatePlan;
import com.example.hygimeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MicroclimatePlanRepository extends JpaRepository<MicroclimatePlan, Integer> {
    Optional<MicroclimatePlan> findMicroclimatePlanById(Integer id);
    MicroclimatePlan findMicroclimatePlanByUser(User user);
    List<MicroclimatePlan> findMicroclimatePlansByUser(User user);
}
