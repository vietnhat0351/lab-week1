package com.example.labweek2.service;

import com.example.labweek2.entities.Role;
import com.example.labweek2.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository repository;

    public RoleService() {
        repository = new RoleRepository();
    }

    public Role getAccountRole(int accountId) {
        return repository.getAccountRole(accountId);
    }
}
