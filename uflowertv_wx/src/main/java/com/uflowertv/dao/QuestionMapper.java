package com.uflowertv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.model.Question;
import com.uflowertv.model.QuestionExample;
import com.uflowertv.model.QuestionWithBLOBs;

public interface QuestionMapper {
    int countByExample(QuestionExample example);
    int countByExampleWithBLOBsByPageHelper(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(QuestionWithBLOBs record);

    int insertSelective(QuestionWithBLOBs record);

    List<QuestionWithBLOBs> selectByExampleWithBLOBs(QuestionExample example);
    //复合查询
    List<QuestionWithBLOBs> selectByExampleWithBLOBsByPageHelper(QuestionExample example);
    
    List<Question> selectByExample(QuestionExample example);

    QuestionWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QuestionWithBLOBs record, @Param("example") QuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") QuestionWithBLOBs record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(QuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionWithBLOBs record);

    int updateByPrimaryKey(Question record);
}