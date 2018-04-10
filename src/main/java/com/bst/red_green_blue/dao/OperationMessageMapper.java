package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.OperationMessage;
import com.bst.red_green_blue.pojo.OperationMessageExample;
import com.bst.red_green_blue.pojo.OperationMessageWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationMessageMapper {
    int countByExample(OperationMessageExample example);

    int deleteByExample(OperationMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(OperationMessageWithBLOBs record);

    int insertSelective(OperationMessageWithBLOBs record);

    List<OperationMessageWithBLOBs> selectByExampleWithBLOBs(OperationMessageExample example);

    List<OperationMessage> selectByExample(OperationMessageExample example);

    OperationMessageWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OperationMessageWithBLOBs record, @Param("example") OperationMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") OperationMessageWithBLOBs record, @Param("example") OperationMessageExample example);

    int updateByExample(@Param("record") OperationMessage record, @Param("example") OperationMessageExample example);

    int updateByPrimaryKeySelective(OperationMessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OperationMessageWithBLOBs record);

    int updateByPrimaryKey(OperationMessage record);
}