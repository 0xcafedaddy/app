package com.uflowertv.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.statistics.model.Play;
import com.uflowertv.statistics.model.PlayExample;

public interface PlayMapper {
    int countByExample(PlayExample example);

    int deleteByExample(PlayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Play record);

    int insertSelective(Play record);

    List<Play> selectByExample(PlayExample example);

    Play selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Play record, @Param("example") PlayExample example);

    int updateByExample(@Param("record") Play record, @Param("example") PlayExample example);

    int updateByPrimaryKeySelective(Play record);

    int updateByPrimaryKey(Play record);
}