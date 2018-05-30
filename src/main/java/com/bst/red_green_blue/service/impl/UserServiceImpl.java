package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.TeamMemberMapper;
import com.bst.red_green_blue.dao.TeamMessageMapper;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.*;
import com.bst.red_green_blue.pojo.vo.TeamMessageAndMember;
import com.bst.red_green_blue.pojo.vo.UserVo;
import com.bst.red_green_blue.service.IUserService;
import com.bst.red_green_blue.util.JwtUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeamMessageMapper teamMessageMapper;

    @Autowired
    private TeamMemberMapper teamMemberMapper;


    @Override
    public ServerResponse<UserVo> login(String phoneNumber, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneNumberEqualTo(phoneNumber).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        } else {
            User user = users.get(0);
            if (user.getStatus() == 1) {
                return ServerResponse.createByErrorMessage("你的账户存在问题请和管理员联系");
            }
            //todo
            Gson gson = new Gson();
            String userJson = gson.toJson(user);
            String token = JwtUtil.createJWT(userJson);
            System.out.println(gson.fromJson(userJson, User.class));
            //            User user1 = gson.fromJson(userJson, User.class);
            UserVo userVo = new UserVo();
            userVo.setUser(user);
            userVo.setToken(token);
            return ServerResponse.createBySuccess("登陆成功", userVo);
        }
    }

    @Override
    public ServerResponse<String> addUser(User user) {  
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneNumberEqualTo(user.getPhoneNumber());
        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() != 0) {
            return ServerResponse.createByErrorMessage("该手机号码已绑定用户");
        }
        int insert = userMapper.insertSelective(user);
        if (insert == 0) {
            return ServerResponse.createByErrorMessage("出现一个小问题添加失败");
        } else {
            return ServerResponse.createByErrorMessage("添加成功");
        }

    }

    @Override
    public ServerResponse<String> deleteUser(String phoneNumber) {
        User user = userMapper.selectByPrimaryKey(phoneNumber);
        user.setStatus(1);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != 0) {
            return ServerResponse.createBySuccessMessage("删除用户成功");
        } else {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }


    @Override
    public ServerResponse<String> updateUser(User user) {

        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != 0) {
            return ServerResponse.createByErrorMessage("更新成功");
        } else {
            return ServerResponse.createByErrorMessage("更新失败");

        }

    }


    @Override
    public ServerResponse<List> getTeamList() {
        //当id不为空的时候查询出所有的teamMessageAndMembers对象
        TeamMessageExample teamMessageExample = new TeamMessageExample();
        teamMessageExample.createCriteria().andIdNotEqualTo(" ");
        List<TeamMessage> teamMessages = teamMessageMapper.selectByExample(teamMessageExample);
        //返回给前端的TeamMessageAndMember集合
        List<TeamMessageAndMember> teamMessageAndMembers = new ArrayList<>();
        //遍历teamMessages集合
        for (int i = 0; i < teamMessages.size(); i++) {
            //获取team_id
            TeamMessage teamMessage = teamMessages.get(i);
            TeamMemberExample teamMemberExample = new TeamMemberExample();
            //根据id查询teamMembers列表
            teamMemberExample.createCriteria().andTeamIdEqualTo(teamMessage.getId());
            List<TeamMember> teamMembers = teamMemberMapper.selectByExample(teamMemberExample);
            //创建了teamMessageAndMember对象
            TeamMessageAndMember teamMessageAndMember = new TeamMessageAndMember();
            //将teamMembers集合加入对象teamMessageAndMember对象
            teamMessageAndMember.setTeamMembers(teamMembers);
            //将对象teamMessage加入teamMessageAndMember对象
            teamMessageAndMember.setTeamMessage(teamMessage);
            //判断teamMessage的状态
            if (teamMessage.getStatus() == 0) {
                //如果状态合法则加入到teamMessageAndMember集合中
                teamMessageAndMembers.add(teamMessageAndMember);
            }

        }
        return ServerResponse.createBySuccess(teamMessageAndMembers);

    }




    @Override
    public ServerResponse<String> updatePassword(User user, String password) {
        user.setPassword(password);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 0) {
            return ServerResponse.createByErrorMessage("修改密码失败");
        }
        return ServerResponse.createBySuccess("修改密码成功");
    }


}




