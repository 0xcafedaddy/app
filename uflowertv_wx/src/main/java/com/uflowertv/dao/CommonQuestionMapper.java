package com.uflowertv.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.uflowertv.model.po.CommonQuestion;

import java.util.List;

public interface CommonQuestionMapper extends BaseMapper<CommonQuestion>{

    List<CommonQuestion> selectByString(int id);

    int countByParameter(int id);

    int batchUpdateCommonQuestion(List<CommonQuestion> record);
}