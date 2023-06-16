package com.example.tparkbe.service;

import com.example.tparkbe.exception.NotFoundException;
import com.example.tparkbe.model.Role;
import com.example.tparkbe.model.User;
import com.example.tparkbe.repo.RoleRepo;
import com.example.tparkbe.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User addUser(User user) {
        boolean userExists = userRepo
                .findByEmail(user.getEmail())
                .isPresent();
        if(userExists) {
            throw new IllegalStateException("Email already taken!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public User addRoleToUser(User user, String roleName) {
        boolean userExists = userRepo
                .findByEmail(user.getEmail())
                .isPresent();
        if(!userExists) {
            throw new IllegalStateException("User doesn't exist!");
        }
        Role role = roleRepo.findRoleByName(roleName);
        user.setRole(role);
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
        return userRepo.findUserById(id).orElseThrow(() -> new NotFoundException("User by id " + id + " was not found!"));
    }

    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow(() -> new NotFoundException("User by username " + username + " was not found!"));
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("User by email " + email + " was not found!"));
    }
}
