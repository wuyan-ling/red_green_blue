package com.bst.red_green_blue.controller;


import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.IUserService;
import com.bst.red_green_blue.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService iUserService;

    /**
     * 登陆方法
     *
     * @param phoneNumber 用户名
     * @param password    密码
     * @return user对象
     */


    @PostMapping(value = "/login")
    public ServerResponse<User> login(String phoneNumber, String password, HttpSession session) {

        if (phoneNumber == null || password == null) {
            return ServerResponse.createByErrorMessage("不能为空");
        } else {

            String md5EncodeUtf8Password = MD5Util.MD5EncodeUtf8(password);
            ServerResponse<User> loginStatus = iUserService.login(phoneNumber, md5EncodeUtf8Password);
            session.setAttribute(Constant.CURRENT_USER, loginStatus.getData());
            return loginStatus;
        }
    }

    @PostMapping(value = "/addUser")
    public ServerResponse<String> addUser(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }

        if (currentUser.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return ServerResponse.createByErrorMessage("不是管理员没有权限");
        } else {

            String md5EncodeUtf8Password = MD5Util.MD5EncodeUtf8(user.getPassword());
            user.setPassword(md5EncodeUtf8Password);
            return iUserService.addUser(user);

        }

    }
    @PostMapping(value = "/deleteUser")
    public ServerResponse<String> deleteUser(String phoneNumber, HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return ServerResponse.createByErrorMessage("不是管理员没有权限");
        }
        if (phoneNumber == null) {
            return ServerResponse.createByErrorMessage("请输入要删除的用户手机号码");
        } else {

            return iUserService.deleteUser(phoneNumber, session);
        }

    }

    @PostMapping(value = "/updateUser")
    public ServerResponse<String> updateUser(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        if (currentUser.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return ServerResponse.createByErrorMessage("不是管理员没有权限");
        } else {
            String md5EncodeUtf8 = MD5Util.MD5EncodeUtf8(user.getPassword());
           user.setPassword(md5EncodeUtf8);
            return iUserService.updateUser(user, session);
        }

    }




}

