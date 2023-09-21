package com.example.labweek2.repository;

import com.example.labweek2.ConnectDB;
import com.example.labweek2.entities.Account;
import com.example.labweek2.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class RoleRepository {

    private EntityManagerFactory entityManagerFactory = ConnectDB.getInstance().getEntityManagerFactory();

    public Role getAccountRole(int accountId) {
        Role role = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            String sql = "SELECT    Role.*\n" +
                    "FROM         Account INNER JOIN\n" +
                    "                      GrantAccess ON Account.account_id = GrantAccess.account_account_id INNER JOIN\n" +
                    "                      Role ON GrantAccess.role_role_id = Role.role_id\n" +
                    "where account_id = '"+accountId+"' and is_grant = 1";
            role = (Role) entityManager.createNativeQuery(sql, Role.class).getSingleResult();
            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
        return role;
    }
}
