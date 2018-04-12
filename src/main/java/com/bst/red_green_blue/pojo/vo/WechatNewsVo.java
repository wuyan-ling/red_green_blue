package com.bst.red_green_blue.pojo.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author XHJ
 * 2018/4/12 15:30
 */
public class WechatNewsVo {
    @NotBlank(message = "标题不能为空")
    private String title;

    private String picture;
    @NotBlank(message = "内容不能为空")
    private String description;

    public WechatNewsVo(String title, String picture, String description) {
        this.title = title;
        this.picture = picture;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public WechatNewsVo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public WechatNewsVo setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WechatNewsVo setDescription(String description) {
        this.description = description;
        return this;
    }
}
