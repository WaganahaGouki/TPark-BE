package com.example.tparkbe.service;

import com.example.tparkbe.model.User;
import com.example.tparkbe.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User loginUser(String email, String password) {
        User user = userRepo.findUserByEmail(email);
        if(user == null) {
            throw new IllegalStateException("User doesn't exist!");
        }
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new IllegalStateException("Incorrect password!");
        }
        return user;
    }
}
