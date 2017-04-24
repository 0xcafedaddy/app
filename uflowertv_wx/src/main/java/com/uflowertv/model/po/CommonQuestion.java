package com.uflowertv.model.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("wx_question_tree")
public class CommonQuestion {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String question;

    private String p_question;

    @TableField(value = "question_type")
    private String questionType;

    private String createTime;

    private String updateTime;

    private Integer code;

}