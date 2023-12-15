package com.example.hygimeter.repository;

import com.example.hygimeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Integer id);
}
