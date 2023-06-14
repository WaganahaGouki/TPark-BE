package com.example.tparkbe.controller;

import com.example.tparkbe.model.User;
import com.example.tparkbe.service.LoginService;
import com.example.tparkbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final LoginService loginService;

    @GetMapping("/{email}/{password}")
    public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        User user = userService.findByEmail(email);
        loginService.loginUser(user.getEmail(), password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
