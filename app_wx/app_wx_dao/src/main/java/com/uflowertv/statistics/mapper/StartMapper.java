package com.uflowertv.statistics.mapper;

import com.uflowertv.model.DayActiveCount;
import com.uflowertv.model.Start;
import com.uflowertv.model.StartExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
    
	List<DayActiveCount> getTimeUserActiveList(@Param(value = "start") Date start, @Param(value = "end") Date end);

	int getTimeUserActiveCount(@Param(value = "start") Date start, @Param(value = "end") Date end);

}