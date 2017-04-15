package com.uflowertv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uflowertv.model.CommonQuestion;
import com.uflowertv.model.CommonQuestionExample;

public interface CommonQuestionMapper {
	int countByExample(CommonQuestionExample example);
	
    int countByParameter(int id);

    int deleteByExample(CommonQuestionExample example);

    int deleteByPrimaryKey(int id);

    int insert(CommonQuestion record);

    int insertSelective(CommonQuestion record);

    List<CommonQuestion> selectByExample(CommonQuestionExample example);
    
    List<CommonQuestion> selectByString(int id);

    CommonQuestion selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") CommonQuestion record, @Param("example") CommonQuestionExample example);

    int updateByExample(@Param("record") CommonQuestion record, @Param("example") CommonQuestionExample example);

    int updateByPrimaryKeySelective(CommonQuestion record);

    int updateByPrimaryKey(CommonQuestion record);
    
    int batchUpdateCommonQuestion(List<CommonQuestion> record);
}