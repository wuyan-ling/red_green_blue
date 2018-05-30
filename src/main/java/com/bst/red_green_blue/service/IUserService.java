package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.UserVo;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface IUserService {
    /**
     * 登陆
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    ServerResponse<UserVo> login(String phoneNumber, String password);


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    ServerResponse<String> addUser(User user);


    /**
     * 删除用户
     *
     * @param phoneNumber
     * @return
     */
    ServerResponse<String> deleteUser(String phoneNumber);


    /**
     * 修改用户信息
     *
     * @param user
     */
    ServerResponse<String> updateUser(User user);

    /**
     * 查询团队信息列表
     *
     * @return
     */
    ServerResponse<List> getTeamList();


    /**
     * 修改用户密码
     *
     * @param password
     * @return
     */
    ServerResponse<String> updatePassword(User user, String password);

}


