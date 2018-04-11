package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.UserExample;
import com.bst.red_green_blue.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<User> login(String phoneNumber, String password) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneNumberEqualTo(phoneNumber).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        } else {
            return ServerResponse.createBySuccess("登陆成功",users.get(0));
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
    public ServerResponse<String> deleteUser(String phoneNumber, HttpSession session) {
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
    public ServerResponse<String> updateUser(User user, HttpSession session) {

        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != 0) {
            return ServerResponse.createByErrorMessage("更新成功");
        } else {
            return ServerResponse.createByErrorMessage("更新失败");

        }

    }


}




