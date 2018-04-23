package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.TeamMemberMapper;
import com.bst.red_green_blue.dao.TeamMessageMapper;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.*;
import com.bst.red_green_blue.pojo.vo.TeamMessageAndMember;
import com.bst.red_green_blue.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements ITeamService {


    @Autowired
    private TeamMessageMapper teamMessageMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeamMemberMapper teamMemberMapper;

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


    @Override
    public ServerResponse<TeamMember> addTeamMember(String teamId, String name, String phoneNumber) {
        String id = String.valueOf(UUID.randomUUID());
        TeamMember teamMember = new TeamMember(id, teamId, name, phoneNumber);
        int i = teamMemberMapper.insertSelective(teamMember);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("添加成员失败");
        }
        return ServerResponse.createBySuccessMessage("添加成员成功");

    }

    @Override
    public ServerResponse<TeamMember> deleteTeamMember(String phoneNumber) {
        TeamMemberExample teamMemberExample = new TeamMemberExample();
        teamMemberExample.createCriteria().andPhoneNumberEqualTo(phoneNumber);
        int i = teamMemberMapper.deleteByExample(teamMemberExample);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("删除成员失败");
        }
        return ServerResponse.createBySuccessMessage("删除成员成功");
    }


    @Override
    public ServerResponse<TeamMessageAndMember> getTeamMessage(User user) {
        //根据用户对象中的teamId获取所在团队
        String teamId = user.getTeamId();
        TeamMessageExample teamMessageExample = new TeamMessageExample();
        teamMessageExample.createCriteria().andIdEqualTo(teamId);
        List<TeamMessage> teamMessages = teamMessageMapper.selectByExample(teamMessageExample);
        if (teamMessages.size() == 0) {
            return ServerResponse.createByErrorMessage("你还没有初始化团队");
        }
        //创建TeamMessageAndMember对象
        TeamMessageAndMember teamMessageAndMember = new TeamMessageAndMember();
        //将团队信息teamMessages加入TeamMessageAndMember对象中
        teamMessageAndMember.setTeamMessage(teamMessages.get(0));
        //查询改团队的成员信息集合
        TeamMemberExample teamMemberExample = new TeamMemberExample();
        teamMemberExample.createCriteria().andTeamIdEqualTo(teamId);
        List<TeamMember> teamMembers = teamMemberMapper.selectByExample(teamMemberExample);
        //将团队成员集合teamMembers加入TeamMessageAndMember中
        teamMessageAndMember.setTeamMembers(teamMembers);
        return ServerResponse.createBySuccess(teamMessageAndMember);

    }

}
