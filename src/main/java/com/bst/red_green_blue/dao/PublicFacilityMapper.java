package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.PublicFacilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublicFacilityMapper {
    int countByExample(PublicFacilityExample example);

    int deleteByExample(PublicFacilityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PublicFacility record);

    int insertSelective(PublicFacility record);

    List<PublicFacility> selectByExample(PublicFacilityExample example);

    PublicFacility selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PublicFacility record, @Param("example") PublicFacilityExample example);

    int updateByExample(@Param("record") PublicFacility record, @Param("example") PublicFacilityExample example);

    int updateByPrimaryKeySelective(PublicFacility record);

    int updateByPrimaryKey(PublicFacility record);
}