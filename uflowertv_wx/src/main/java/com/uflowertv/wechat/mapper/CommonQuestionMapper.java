package com.uflowertv.wechat.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.uflowertv.wechat.model.CommonQuestion;

import java.util.List;

public interface CommonQuestionMapper extends BaseMapper<CommonQuestion>{

    List<CommonQuestion> selectByString(int id);

    int countByParameter(int id);

    int batchUpdateCommonQuestion(List<CommonQuestion> record);
}