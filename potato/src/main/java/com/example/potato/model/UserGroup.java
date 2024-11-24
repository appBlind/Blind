package com.example.potato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupId;

    @Column(nullable = false, length = 100)
    private String userGroupName;

    @OneToMany(mappedBy = "userGroup")
    private List<User> users;

    private String register;
    private String regDatetime; //등록일
    private String lastModifier;
    private String lastModDatetime;
    private String state;
    private boolean isDeleted;

    // Getter and Setter for userGroupId
    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    // Getter and Setter for userGroupName
    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    // Getter and Setter for users
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Getter and Setter for register
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    // Getter and Setter for regDatetime
    public String getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(String regDatetime) {
        this.regDatetime = regDatetime;
    }

    // Getter and Setter for lastModifier
    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    // Getter and Setter for lastModDatetime
    public String getLastModDatetime() {
        return lastModDatetime;
    }

    public void setLastModDatetime(String lastModDatetime) {
        this.lastModDatetime = lastModDatetime;
    }

    // Getter and Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Getter and Setter for isDeleted
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
