package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.TeamMessageMapper;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TeamService implements ITeamService {


    @Autowired
    private TeamMessageMapper teamMessageMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public ServerResponse<TeamMessage> insertTeam(TeamMessage teamMessage, User user) {
        String teamId = UUID.randomUUID().toString();
        teamMessage.setId(teamId);
        int i = teamMessageMapper.insertSelective(teamMessage);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("初始化团队失败");
        }
        user.setTeamId(teamId);
        int i1 = userMapper.updateByPrimaryKeySelective(user);
        if (i1 == 0) {
            return ServerResponse.createByErrorMessage("初始化团队失败");
        }
        return ServerResponse.createBySuccess("初始化团队成功", teamMessage);

    }

    @Override
    public ServerResponse<TeamMessage> updateTeam(TeamMessage teamMessage) {
        int i = teamMessageMapper.updateByPrimaryKey(teamMessage);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("更新失败");
        }

        return ServerResponse.createBySuccess("更新成功", teamMessage);
    }


}
