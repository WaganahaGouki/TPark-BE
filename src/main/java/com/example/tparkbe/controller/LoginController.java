package com.example.tparkbe.controller;

import com.example.tparkbe.model.Login;
import com.example.tparkbe.model.User;
import com.example.tparkbe.service.LoginService;
import com.example.tparkbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final LoginService loginService;

    @GetMapping()
    public ResponseEntity<User> login(@RequestBody Login login) {
        User user = userService.findByEmail(login.getEmail());
        loginService.loginUser(user.getEmail(), login.getPassword());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
