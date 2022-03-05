package com.kata.pp3_1_1.service;

import com.kata.pp3_1_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kata.pp3_1_1.repository.UserRepository;

import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User findById(int id){

        return userRepository.findById(id).get();
    }

    public User addUser(User user){

        return userRepository.save(user);
    }

    public void deleteUser(int id){

        userRepository.deleteById(id);
    }

    public void editUser(User user){

        userRepository.save(user);
    }

    public List<User> showUsers(){

        return userRepository.findAll();
    }
}
