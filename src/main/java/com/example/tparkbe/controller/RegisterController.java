package com.example.tparkbe.controller;

import com.example.tparkbe.model.Register;
import com.example.tparkbe.model.User;
import com.example.tparkbe.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/register")
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping()
    public User register(@RequestBody Register request) {
        return registerService.register(request);
    }
}
