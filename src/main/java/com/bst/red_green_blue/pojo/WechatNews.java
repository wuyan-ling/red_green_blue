package com.bst.red_green_blue.pojo;

public class WechatNews {
    private String id;

    private String title;

    private String picture;

    private String description;

    private Long time;

    private String teamId;

    public WechatNews(String id, String title, String picture, String description, Long time, String teamId) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.time = time;
        this.teamId = teamId;
    }

    public WechatNews() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }
}