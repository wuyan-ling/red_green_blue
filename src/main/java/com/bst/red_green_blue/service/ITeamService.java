package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.User;


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
     * @param teamMessage
     * @return
     */
    ServerResponse<TeamMessage> updateTeam(TeamMessage teamMessage);
}
