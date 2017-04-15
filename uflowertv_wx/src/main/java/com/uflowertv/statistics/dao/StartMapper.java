package com.uflowertv.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.statistics.model.DayActiveCount;
import com.uflowertv.statistics.model.Start;
import com.uflowertv.statistics.model.StartExample;

public interface StartMapper {
    int countByExample(StartExample example);

    int deleteByExample(StartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Start record);

    int insertSelective(Start record);

    List<Start> selectByExample(StartExample example);

    Start selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Start record, @Param("example") StartExample example);

    int updateByExample(@Param("record") Start record, @Param("example") StartExample example);

    int updateByPrimaryKeySelective(Start record);

    int updateByPrimaryKey(Start record);
    
	List<DayActiveCount> getDayActiveList(@Param(value = "recordIndex") int recordIndex, @Param(value = "pageSize") int pageSize);
	int getDayActiveCount();

}