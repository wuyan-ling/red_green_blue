package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.TeamMember;
import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.TeamMessageAndMember;
import com.bst.red_green_blue.service.ITeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ITeamService iTeamService;

    @Autowired
    private UserMapper userMapper;




    @ApiOperation("初始化团队信息")
    @PostMapping("/updateOrInsertTeam")
    public ServerResponse<TeamMessage> updateOrInsertTeam(HttpSession session, TeamMessage teamMessage) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        if (user.getTeamId() == null && user.getMark() == Constant.Role.ROLE_CUSTOMER) {
            return iTeamService.insertTeam(teamMessage, user);
        }
        if (user.getTeamId() == null && user.getMark() == Constant.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("管理员不应该新建团队，请让团队负责人新建");
        }
        return iTeamService.updateTeam(teamMessage);
    }

    @ApiOperation("添加团队成员")
    @PostMapping("/addTeamMember")
    public ServerResponse<TeamMember> addTeamMember(HttpSession session, String name, String phoneNumber) {

        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        if (user.getMark() == Constant.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("管理员不应该新建团队成员，请让团队负责人新建");
        }
        String teamId = user.getTeamId();
        if (teamId==null) {
            return ServerResponse.createByErrorMessage("请先初始化团队信息");
        }
        User user1 = userMapper.selectByPrimaryKey(phoneNumber);
        if (user1 != null) {
            return ServerResponse.createByErrorMessage("该手机已被使用");
        }
        return iTeamService.addTeamMember(teamId, name, phoneNumber);

    }

    @ApiOperation("删除团队成员")
    @PostMapping("/deleteTeamMember")
    public ServerResponse<TeamMember> deleteTeamMember(HttpSession session, String phoneNumber) {

        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        if (user.getMark() == Constant.Role.ROLE_ADMIN) {
            return ServerResponse.createByErrorMessage("管理员不应该删除团队成员，请让团队负责人删除");
        }

        return iTeamService.deleteTeamMember(session, phoneNumber);
    }
    @ApiOperation("获取团队信息")
    @GetMapping("/getTeamMessage")
    public ServerResponse<TeamMessageAndMember> getTeamMessage(HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("请登陆");
        }
        return iTeamService.getTeamMessage(currentUser);
    }



}
