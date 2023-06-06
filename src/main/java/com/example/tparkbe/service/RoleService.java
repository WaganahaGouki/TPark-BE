package com.example.tparkbe.service;

import com.example.tparkbe.model.Role;
import com.example.tparkbe.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public Role addRole(Role role) {
        return roleRepo.save(role);
    }
}
