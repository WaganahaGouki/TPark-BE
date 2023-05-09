package com.example.tparkbe.service;

import com.example.tparkbe.exception.UserNotFoundException;
import com.example.tparkbe.model.User;
import com.example.tparkbe.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setUserCode(UUID.randomUUID());
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found!"));
    }
}
