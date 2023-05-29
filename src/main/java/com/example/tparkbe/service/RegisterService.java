package com.example.tparkbe.service;

import com.example.tparkbe.model.Register;
import com.example.tparkbe.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RegisterService {
    private final UserService userService;
    private final EmailValidator emailValidator;

    public User register(Register request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        return userService.addUser(user);
    }
}
