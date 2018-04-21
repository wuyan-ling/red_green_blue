package com.bst.red_green_blue.pojo.vo;

import com.bst.red_green_blue.pojo.User;

/**
 * @author 杨红星
 * @version 1.0.0
 * @date 2018/4/21
 */
public class UserVo {
    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
