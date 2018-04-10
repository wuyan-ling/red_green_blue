package com.bst.red_green_blue.pojo;

public class TeamMessage {
    private String id;

    private String name;

    private String leader;

    private Integer status;

    public TeamMessage(String id, String name, String leader, Integer status) {
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.status = status;
    }

    public TeamMessage() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}