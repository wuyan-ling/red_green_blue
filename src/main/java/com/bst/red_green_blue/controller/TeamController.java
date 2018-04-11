package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ITeamService iTeamService;



@PostMapping("/updateOrInsertTeam")
public ServerResponse<TeamMessage>updateOrInsertTeam(HttpSession session, TeamMessage teamMessage){
    User user= (User) session.getAttribute(Constant.CURRENT_USER);
    if (user == null) {
        return ServerResponse.createByErrorMessage("请登陆");
    }
    if (user.getTeamId() == null&&user.getMark()==Constant.Role.ROLE_CUSTOMER) {
        return iTeamService.insertTeam(teamMessage,user);
    }
    if (user.getTeamId() == null && user.getMark() == Constant.Role.ROLE_ADMIN) {
        return ServerResponse.createByErrorMessage("管理员不应该新建团队，请让团队负责人新建");
    }
    return iTeamService.updateTeam(teamMessage);


}





}
