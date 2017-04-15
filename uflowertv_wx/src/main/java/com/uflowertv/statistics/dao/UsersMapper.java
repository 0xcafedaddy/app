package com.uflowertv.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.statistics.model.Users;
import com.uflowertv.statistics.model.UsersExample;
import com.uflowertv.statistics.model.UsersKey;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(UsersKey key);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(UsersKey key);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}