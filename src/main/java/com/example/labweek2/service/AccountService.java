package com.example.labweek2.service;

import com.example.labweek2.entities.Account;
import com.example.labweek2.repository.AccountRepository;

import java.util.List;

public class AccountService {
    private AccountRepository repository;

    public AccountService() {
        repository = new AccountRepository();
    }

    public Account findAccountByEmailPassword(String email, String password) {
        return repository.findAccountByEmailPassword(email, password);
    }

    public List<Account> getAllAcount() {
        return repository.getAllAcount();
    }

    public void add(Account account) {
        repository.add(account);
    }

    public Account findById(int id) {
        return repository.findById(id);
    }

    public void delete(Account account) {
        repository.delete(account);
    }
}
