package com.example.labweek2.repository;

import com.example.labweek2.ConnectDB;
import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class GrantAccessRepository {

    private EntityManagerFactory entityManagerFactory = ConnectDB.getInstance().getEntityManagerFactory();

    public void add(GrantAccess grantAccess) {
        // boolean b = false;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(grantAccess);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void grantRole(Account account, String role) {
        EntityTransaction transaction = null;
        if(role.equalsIgnoreCase("admin")) {
            try {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                transaction = entityManager.getTransaction();
                transaction.begin();
                String sql = "update GrantAccess set is_grant = 1 where account_account_id = "+account.getAccountId()+" and role_role_id = 1";
                String sql1 = "update GrantAccess set is_grant = 0 where account_account_id = "+account.getAccountId()+" and role_role_id = 2";
                entityManager.createNativeQuery(sql).executeUpdate();
                entityManager.createNativeQuery(sql1).executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } else {
            try {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                transaction = entityManager.getTransaction();
                transaction.begin();
                String sql = "update GrantAccess set is_grant = 0 where account_account_id = "+account.getAccountId()+" and role_role_id = 1";
                String sql1 = "update GrantAccess set is_grant = 1 where account_account_id = "+account.getAccountId()+" and role_role_id = 2";
                entityManager.createNativeQuery(sql).executeUpdate();
                entityManager.createNativeQuery(sql1).executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
