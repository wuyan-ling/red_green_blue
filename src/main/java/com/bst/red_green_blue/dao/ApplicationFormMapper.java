package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.ApplicationFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationFormMapper {
    int countByExample(ApplicationFormExample example);

    int deleteByExample(ApplicationFormExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApplicationForm record);

    int insertSelective(ApplicationForm record);

    List<ApplicationForm> selectByExample(ApplicationFormExample example);

    ApplicationForm selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApplicationForm record, @Param("example") ApplicationFormExample example);

    int updateByExample(@Param("record") ApplicationForm record, @Param("example") ApplicationFormExample example);

    int updateByPrimaryKeySelective(ApplicationForm record);

    int updateByPrimaryKey(ApplicationForm record);
}