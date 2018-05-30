package com.bst.red_green_blue.pojo;

import lombok.Data;

@Data
public class User {

    private String phoneNumber;

    private String username;

    private String password;

    private Integer mark;

    private Integer status;

    private String teamId;

    public User(String phoneNumber, String username, String password, Integer mark, Integer status, String teamId) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.mark = mark;
        this.status = status;
        this.teamId = teamId;
    }

    public User() {
        super();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber" +":"+ phoneNumber +
                ", username" +":"+  username +
                ", password" + ":"+ password +
                ", mark" +":"+  mark +
                ", status" + ":"+ status +
                ", teamId" + ":"+ teamId +
                '}';
    }

}