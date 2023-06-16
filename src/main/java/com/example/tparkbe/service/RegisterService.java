package com.example.tparkbe.service;

import com.example.tparkbe.model.Register;
import com.example.tparkbe.model.Role;
import com.example.tparkbe.model.User;
import com.example.tparkbe.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final RoleRepo roleRepo;

    public User register(Register request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        Role role = roleRepo.findRoleByName("USER");
        user.setRole(role);
        return userService.addUser(user);
    }
}
