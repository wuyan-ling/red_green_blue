package com.bst.red_green_blue.pojo;

public class WechatNews {
    private String id;

    private String title;

    private String picture;

    private Integer time;

    private String description;

    public WechatNews(String id, String title, String picture, Integer time, String description) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.time = time;
        this.description = description;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}