package com.example.labweek2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Log {
    @Id
    private long id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "login_time")
    private Date loginTime;
    @Column(name = "logout_time")
    private Date LogoutTime;
    private String notes;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", loginTime=" + loginTime +
                ", LogoutTime=" + LogoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return LogoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        LogoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log(long id, String accountId, Date loginTime, Date logoutTime, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.loginTime = loginTime;
        LogoutTime = logoutTime;
        this.notes = notes;
    }

    public Log() {
    }
}
