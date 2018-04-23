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

    public WechatNewsVo(@NotBlank(message = "标题不能为空") String title, String picture,  @NotBlank(message = "内容不能为空")String description) {
        this.title = title;
        this.picture = picture;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "WechatNewsVo{" +
                "title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
