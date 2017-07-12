package com.uflowertv.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName(value = "wx_question")
public class Question {

    /**
     * 消息标识
     */
    @TableId
    private String id;

    /**
     * 微信用户ID
     */
    @TableField(value = "wx_user_id")
    private String wxUserId;

    /**
     *用户手机号
     */
    @TableField(value = "wx_user_phone")
    private String wxUserPhone;

    /**
     * 问题图片URL
     */
    @TableField(value = "wx_user_question_img")
    private String wxUserQuestionImg;

    /**
     * 问题内容
     */
    @TableField(value = "wx_user_question_content")
    private String wxUserQuestionContent;

    /**
     * 问题标题
     */
    @TableField(value = "wx_user_question_title")
    private String wxUserQuestionTitle;

    /**
     * 问题类型
     */
    @TableField(value = "wx_user_question_type")
    private String wxUserQuestionType;

    /**
     * 回复问题图片
     */
    @TableField(value = "reply_question_img")
    private String replyQuestionImg;

    /**
     * 回复人
     */
    @TableField(value = "reply_question_human")
    private String replyQuestionHuman;

    /**
     * 回复内容
     */
    @TableField(value = "reply_question_content")
    private String replyQuestionContent;

    /**
     * 问题创建时间
     */
    private String createTime;

    /**
     * 问题回复时间
     */
    private String completeTime;

    /**
     * 问题状态
     */
    private Integer status;

}