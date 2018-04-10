package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.TeamMessage;
import com.bst.red_green_blue.pojo.TeamMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamMessageMapper {
    int countByExample(TeamMessageExample example);

    int deleteByExample(TeamMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(TeamMessage record);

    int insertSelective(TeamMessage record);

    List<TeamMessage> selectByExample(TeamMessageExample example);

    TeamMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TeamMessage record, @Param("example") TeamMessageExample example);

    int updateByExample(@Param("record") TeamMessage record, @Param("example") TeamMessageExample example);

    int updateByPrimaryKeySelective(TeamMessage record);

    int updateByPrimaryKey(TeamMessage record);
}