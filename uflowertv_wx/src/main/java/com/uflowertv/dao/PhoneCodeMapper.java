package com.uflowertv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.model.PhoneCode;
import com.uflowertv.model.PhoneCodeExample;

public interface PhoneCodeMapper {
    int countByExample(PhoneCodeExample example);

    int deleteByExample(PhoneCodeExample example);

    int deleteByPrimaryKey(String phone);

    int insert(PhoneCode record);

    int insertSelective(PhoneCode record);

    List<PhoneCode> selectByExample(PhoneCodeExample example);

    PhoneCode selectByPrimaryKey(String phone);

    int updateByExampleSelective(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByExample(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByPrimaryKeySelective(PhoneCode record);

    int updateByPrimaryKey(PhoneCode record);
}