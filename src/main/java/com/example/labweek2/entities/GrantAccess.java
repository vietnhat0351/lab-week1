package com.example.labweek2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class GrantAccess {
    @Id
    @ManyToOne
    private Role role;
    @Id
    @ManyToOne
    private Account account;
    @Column(name = "is_grant")

    private boolean isGrant;
    private String notes;

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", isGrant=" + isGrant +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public GrantAccess(Role role, Account account, boolean isGrant, String notes) {
        this.role = role;
        this.account = account;
        this.isGrant = isGrant;
        this.notes = notes;
    }

    public GrantAccess() {
    }
}
