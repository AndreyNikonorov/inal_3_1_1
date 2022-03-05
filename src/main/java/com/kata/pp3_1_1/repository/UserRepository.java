package com.kata.pp3_1_1.repository;

import com.kata.pp3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findBySurname(String surname);

}
