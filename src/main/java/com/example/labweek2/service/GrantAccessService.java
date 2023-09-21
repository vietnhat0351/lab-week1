package com.example.labweek2.service;

import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.GrantAccess;
import com.example.labweek2.repository.GrantAccessRepository;

public class GrantAccessService {
    private GrantAccessRepository repository = new GrantAccessRepository();

    public void add(GrantAccess grantAccess) {
        repository.add(grantAccess);
    }

    public void grantRole(Account account, String role) {
        repository.grantRole(account, role);
    }
}
