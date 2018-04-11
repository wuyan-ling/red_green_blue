package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.OperationMessage;
import com.bst.red_green_blue.pojo.OperationMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationMessageMapper {
    int countByExample(OperationMessageExample example);

    int deleteByExample(OperationMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(OperationMessage record);

    int insertSelective(OperationMessage record);

    List<OperationMessage> selectByExample(OperationMessageExample example);

    OperationMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OperationMessage record, @Param("example") OperationMessageExample example);

    int updateByExample(@Param("record") OperationMessage record, @Param("example") OperationMessageExample example);

    int updateByPrimaryKeySelective(OperationMessage record);

    int updateByPrimaryKey(OperationMessage record);
}