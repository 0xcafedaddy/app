package com.uflowertv.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.statistics.model.PlayEnd;
import com.uflowertv.statistics.model.PlayEndExample;

public interface PlayEndMapper {
    int countByExample(PlayEndExample example);

    int deleteByExample(PlayEndExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayEnd record);

    int insertSelective(PlayEnd record);

    List<PlayEnd> selectByExample(PlayEndExample example);

    PlayEnd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayEnd record, @Param("example") PlayEndExample example);

    int updateByExample(@Param("record") PlayEnd record, @Param("example") PlayEndExample example);

    int updateByPrimaryKeySelective(PlayEnd record);

    int updateByPrimaryKey(PlayEnd record);
}