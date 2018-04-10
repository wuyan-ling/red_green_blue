package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.TeamMember;
import com.bst.red_green_blue.pojo.TeamMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamMemberMapper {
    int countByExample(TeamMemberExample example);

    int deleteByExample(TeamMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    List<TeamMember> selectByExample(TeamMemberExample example);

    TeamMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByExample(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);
}