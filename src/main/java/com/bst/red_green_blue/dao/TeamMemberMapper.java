package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.TeamMember;
import com.bst.red_green_blue.pojo.TeamMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface TeamMemberMapper {
    int countByExample(TeamMemberExample example);

    int deleteByExample(TeamMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    List<TeamMember> selectByExample(TeamMemberExample example);

    TeamMember selectByPrimaryKey(String id);
    // 需要注意方法的返回类型 如果不是List类型的话查询出了多条数据mybatis就会报错
    @Select("SELECT * FROM team_member WHERE phone_number =#{phoneNumber} ")
    List<TeamMember> selecrByPhoneNumber(String phoneNumber);

    int updateByExampleSelective(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByExample(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);
}