package com.bst.red_green_blue.pojo;

public class TeamMember {
    private String id;

    private String teamId;

    private String name;

    private String phoneNumber;

    public TeamMember(String id, String teamId, String name, String phoneNumber) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public TeamMember() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }
}