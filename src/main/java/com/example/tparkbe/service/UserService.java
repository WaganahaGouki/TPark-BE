package com.example.tparkbe.service;

import com.example.tparkbe.exception.UserNotFoundException;
import com.example.tparkbe.model.User;
import com.example.tparkbe.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        boolean userExists = userRepo
                .findUserByEmail(user.getEmail())
                .isPresent();
        if(userExists) {
            throw new IllegalStateException("Email already taken!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        boolean userExists = userRepo
                .findUserById(user.getId())
                .isPresent();
        if(!userExists) {
            throw new IllegalStateException("User doesn't exist!");
        }
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        boolean userExists = userRepo
                .findUserById(id)
                .isPresent();
        if(!userExists) {
            throw new IllegalStateException("User doesn't exist!");
        }
        userRepo.deleteUserById(id);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found!"));
    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by email " + email + " was not found!"));
    }
}
