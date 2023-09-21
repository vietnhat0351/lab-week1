package com.example.labweek2;

import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.GrantAccess;
import com.example.labweek2.entities.Role;
import com.example.labweek2.repository.AccountRepository;
import com.example.labweek2.repository.RoleRepository;
import com.example.labweek2.service.AccountService;
import com.example.labweek2.service.GrantAccessService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();
       try {
           transaction.begin();
           AccountRepository accountRepository = new AccountRepository();

           Account account = new Account("Pham Viet Nhat", "123", "nhat@gmail.com", "123456789", 1);
           Account account1 = new Account("Van Cam Truc", "123", "truc@gmail.com", "123123123", 1);
           Account account2 = new Account("Nguyen Minh Huy", "123", "huy@gmail.com", "987654321", 1);

           Role role = new Role("1", "admin", "quyen quan tri vien", 1);
           Role role1 = new Role("2", "user", "quyen user", 1);

           GrantAccess grantAccess = new GrantAccess(role, account, true, "abc");
           GrantAccess grantAccess1 = new GrantAccess(role1, account, false, "afg");
           GrantAccess grantAccess2 = new GrantAccess(role, account1, true, "abc");
           GrantAccess grantAccess3 = new GrantAccess(role1, account1, false, "abc");
           GrantAccess grantAccess4 = new GrantAccess(role, account2, false, "abc");
           GrantAccess grantAccess5 = new GrantAccess(role1, account2, true, "abc");

           entityManager.persist(account1);
           entityManager.persist(account2);
           entityManager.persist(account);

           entityManager.persist(role);
           entityManager.persist(role1);

           entityManager.persist(grantAccess);
           entityManager.persist(grantAccess1);
           entityManager.persist(grantAccess2);
           entityManager.persist(grantAccess3);
           entityManager.persist(grantAccess4);
           entityManager.persist(grantAccess5);

           transaction.commit();
       } finally {
           if(transaction.isActive()) {
               transaction.rollback();
           }
           entityManager.close();
           entityManagerFactory.close();
       }
//        AccountService accountService = new AccountService();
//        Account account = accountService.findById(3);
//        GrantAccessService grantAccessService = new GrantAccessService();
//        grantAccessService.grantRole(account, "admin");
//        System.out.println(accountService.findById(3));
    }
}