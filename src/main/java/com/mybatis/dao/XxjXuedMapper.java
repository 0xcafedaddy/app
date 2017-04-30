package com.mybatis.dao;

import com.mybatis.entity.XxjXued;
import com.mybatis.entity.XxjXuedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XxjXuedMapper {
    int countByExample(XxjXuedExample example);

    int deleteByExample(XxjXuedExample example);

    int deleteByPrimaryKey(Integer xuedId);

    int insert(XxjXued record);

    int insertSelective(XxjXued record);

    List<XxjXued> selectByExample(XxjXuedExample example);

    XxjXued selectByPrimaryKey(Integer xuedId);

    int updateByExampleSelective(@Param("record") XxjXued record, @Param("example") XxjXuedExample example);

    int updateByExample(@Param("record") XxjXued record, @Param("example") XxjXuedExample example);

    int updateByPrimaryKeySelective(XxjXued record);

    int updateByPrimaryKey(XxjXued record);
}