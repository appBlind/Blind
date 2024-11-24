package com.example.potato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "userGroupId")
    private UserGroup userGroup;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToMany(mappedBy = "user")
    private  List<UserLog> userLogs;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, unique = true, length = 32)
    private String email;
    private String phone;

    @Column(nullable = false, length = 64)
    private String password;
    private String regDate; // 등록일
    private String state;
    private boolean isDeleted;
    private int pwdFailCnt;


//  아직 잘 모르는 부분, 수정 필요
    // getter and setter for id
    public Long getUserId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    // Generate getter
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public Position getPosition() {
        return position;
    }

    public List<UserLog> getUserLogs() {
        return userLogs;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getState() {
        return state;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int getPwdFailCnt() {
        return pwdFailCnt;
    }

    //Generate setter
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setPwdFailCnt(int pwdFailCnt) {
        this.pwdFailCnt = pwdFailCnt;
    }
}
