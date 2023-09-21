package com.example.labweek2.repository;

import com.example.labweek2.ConnectDB;
import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.GrantAccess;
import jakarta.persistence.*;

import java.util.List;

import static com.example.labweek2.ConnectDB.*;

public class AccountRepository {
//    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityManagerFactory entityManagerFactory = ConnectDB.getInstance().getEntityManagerFactory();
    public AccountRepository() {
    }

    public Account findAccountByEmailPassword(String email, String password) {
        Account account = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = "from Account as acc where acc.email = :email and acc.password = :password";
            account = entityManager.createQuery(hql, Account.class)
                    .setParameter("email", email)
                    .setParameter("password", password).getSingleResult();
            transaction.commit();
        } catch (Exception exception){
            if(transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
//            entityManagerFactory.close();
        }
        return account;
    }

    public List<Account> getAllAcount() {
        List<Account> accountList = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = "from Account";
            accountList = entityManager.createQuery(hql, Account.class).getResultList();

            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
//            entityManagerFactory.close();
        }
        return accountList;
    }

    public void add(Account account) {
        // boolean b = false;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(account);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Account findById(int accountId) {
        Account account = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            String sql = "select * from account where account_id = " + accountId;
            account = (Account) entityManager.createNativeQuery(sql, Account.class).getSingleResult();
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return account;
    }

    public void delete(Account account) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createQuery("update Account set status = 0 where accountId = " + account.getAccountId()).executeUpdate();
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
