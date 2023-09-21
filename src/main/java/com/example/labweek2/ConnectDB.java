package com.example.labweek2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {

    private static ConnectDB instance;
    private EntityManagerFactory entityManagerFactory;

    public ConnectDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static ConnectDB getInstance() {
        if(instance == null)
            instance = new ConnectDB();
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
