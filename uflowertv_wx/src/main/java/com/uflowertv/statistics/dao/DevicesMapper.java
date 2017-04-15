package com.uflowertv.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.statistics.model.Devices;
import com.uflowertv.statistics.model.DevicesExample;
import com.uflowertv.statistics.model.DevicesKey;

public interface DevicesMapper {
    int countByExample(DevicesExample example);

    int deleteByExample(DevicesExample example);

    int deleteByPrimaryKey(DevicesKey key);

    int insert(Devices record);

    int insertSelective(Devices record);

    List<Devices> selectByExample(DevicesExample example);

    Devices selectByPrimaryKey(DevicesKey key);

    int updateByExampleSelective(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByExample(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);
}