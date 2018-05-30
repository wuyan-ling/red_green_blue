package com.bst.red_green_blue.controller;


import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.Token;
import com.bst.red_green_blue.pojo.vo.UserVo;
import com.bst.red_green_blue.service.IUserService;
import com.bst.red_green_blue.util.GsonUtil;
import com.bst.red_green_blue.util.JwtUtil;
import com.bst.red_green_blue.util.MD5Util;
import com.bst.red_green_blue.validator.TokenConstraint;
import com.sun.activation.registries.MailcapParseException;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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
    public ServerResponse<UserVo> login(@NonNull String phoneNumber, String password) {

        if (phoneNumber == null || password == null) {
            return ServerResponse.createByErrorMessage("参数不能为空");
        } else {
            String md5EncodeUtf8Password = MD5Util.MD5EncodeUtf8(password);
            ServerResponse<UserVo> loginStatus = iUserService.login(phoneNumber, md5EncodeUtf8Password);
            return loginStatus;
        }
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "/addUser")
    public ServerResponse<String> addUser(User user, String token) throws MailcapParseException{
        if (token == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
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
    public ServerResponse<String> deleteUser(String phoneNumber, String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return ServerResponse.createByErrorMessage("不是管理员没有权限");
        }
        if (phoneNumber == null) {
            return ServerResponse.createByErrorMessage("请输入要删除的用户手机号码");
        } else {
            return iUserService.deleteUser(phoneNumber);
        }

    }

    @ApiOperation("更新用户")
    @PostMapping(value = "/updateUser")
    public ServerResponse<String> updateUser(User user, String token) throws MailcapParseException {

        if (token == null) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return ServerResponse.createByErrorMessage("不是管理员没有权限");
        } else {
            String md5EncodeUtf8 = MD5Util.MD5EncodeUtf8(user.getPassword());
            user.setPassword(md5EncodeUtf8);
            return iUserService.updateUser(user);
        }

    }

    @ApiOperation("获取团队列表")
    @GetMapping("/getTeamList")
    public ServerResponse<List> getTeamList(Token token) throws MailcapParseException {

        if (token.getRole() != Constant.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("你没有查看的权限");
        }
        return iUserService.getTeamList();

    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    public ServerResponse<String> updatePassword(String token, String password) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        String s = MD5Util.MD5EncodeUtf8(password);
        User currentUser = GsonUtil.createUserUseToToken(token);
        return iUserService.updatePassword(currentUser, s);
    }

    @ApiOperation("退出登陆")
    @PostMapping("/logout")
    public ServerResponse<String> logout(String token) {

        Claims claims = JwtUtil.parseJWT(token);
        claims.setId(Constant.Consts.STATUS_NOT_VALID);
        System.out.println("成功退出登录");
        return ServerResponse.createBySuccess("你已成功退出");

    }

}

