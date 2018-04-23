package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.TeamMember;
import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.TeamMessageAndMember;

import javax.servlet.http.HttpSession;


public interface ITeamService {
    /**
     * 初始化团队信息
     *
     * @param teamMessage
     * @return
     */
    ServerResponse<TeamMessage> insertTeam(TeamMessage teamMessage, User user);


    /**
     * 更新团队信息
     *
     * @param teamMessage
     * @return
     */
    ServerResponse<TeamMessage> updateTeam(TeamMessage teamMessage);


    /**
     * 增加团队成员
     *
     * @param teamId
     * @param name
     * @param phoneNumber
     * @return
     */
    ServerResponse<TeamMember> addTeamMember(String teamId, String name, String phoneNumber);


    /**
     * 删除团队成员
     *
     * @param phoneNumber
     * @return
     */
    ServerResponse<TeamMember> deleteTeamMember(String phoneNumber);

    /**
     * 获取团队信息
     *
     * @return
     */
    ServerResponse<TeamMessageAndMember> getTeamMessage(User user);
}





