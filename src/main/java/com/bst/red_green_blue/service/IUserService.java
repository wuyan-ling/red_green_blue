package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;

import javax.servlet.http.HttpSession;


public interface IUserService {
    /**
     * 登陆
     * @param phoneNumber
     * @param password
     * @return
     */

    ServerResponse<User> login(String phoneNumber, String password);


    /**
     * 添加用户
     * @param user
     * @return
     */
    ServerResponse<String> addUser(User user);


    /**
     * 删除用户
     * @param phoneNumber
     * @param session
     * @return
     */
    ServerResponse<String> deleteUser(String phoneNumber, HttpSession session);
}