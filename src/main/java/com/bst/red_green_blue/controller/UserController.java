package com.bst.red_green_blue.controller;


import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.IUserService;
import com.bst.red_green_blue.util.MD5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


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

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public ServerResponse<User> login(String phoneNumber, String password, HttpSession session) {

        if (phoneNumber == null || password == null) {
            return ServerResponse.createByErrorMessage("参数不能为空");
        } else {
            String md5EncodeUtf8Password = MD5Util.MD5EncodeUtf8(password);
            ServerResponse<User> loginStatus = iUserService.login(phoneNumber, md5EncodeUtf8Password);
            session.setAttribute(Constant.CURRENT_USER, loginStatus.getData());
            return loginStatus;
        }
    }

    @ApiOperation("新增用户")
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

    @ApiOperation("删除用户")
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

    @ApiOperation("更新用户")
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

    @ApiOperation("获取团队列表")
    @GetMapping("/getTeamList")
    public ServerResponse<List> getTeamList() {
        return iUserService.getTeamList();

    }
    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    public ServerResponse<String>updatePassword(HttpSession session,String password){
        User attribute =(User) session.getAttribute(Constant.CURRENT_USER);
        if (attribute == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        String s = MD5Util.MD5EncodeUtf8(password);
        return iUserService.updatePassword(attribute,s);
    }
    @ApiOperation("退出登陆")
    @PostMapping("/logout")
    public ServerResponse<String>logout(HttpSession session){
        session.setAttribute(Constant.CURRENT_USER, null);
        return ServerResponse.createBySuccess("你已成功退出");

    }

}

