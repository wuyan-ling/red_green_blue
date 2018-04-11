package com.bst.red_green_blue.dao;

import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.WechatNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatNewsMapper {
    int countByExample(WechatNewsExample example);

    int deleteByExample(WechatNewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(WechatNews record);

    int insertSelective(WechatNews record);

    List<WechatNews> selectByExample(WechatNewsExample example);

    WechatNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WechatNews record, @Param("example") WechatNewsExample example);

    int updateByExample(@Param("record") WechatNews record, @Param("example") WechatNewsExample example);

    int updateByPrimaryKeySelective(WechatNews record);

    int updateByPrimaryKey(WechatNews record);
}