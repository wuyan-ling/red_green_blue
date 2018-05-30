package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String phoneNumber);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    //测试使用注解进行查询
//    @Select("SELECT * FROM user WHERE phone_number =#{phoneNumber}")
    User selectByPrimaryKey(String phoneNumber);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}