package com.uflowertv.model;

import org.apache.commons.lang3.StringUtils;

import com.uflowertv.util.GUIDUtil;

public class Question {
    private String id;

    private String wxUserId;

    private String wxUserPhone;

    private String wxUserQuestionImg;

    private String wxUserQuestionTitle;

    private String wxUserQuestionType;

    private String replyQuestionImg;

    private String replyQuestionHuman;

    private String createtime;

    private String completetime;

    private Integer status;

    public String getId() {
    	if(StringUtils.isBlank(id)) return GUIDUtil.get();
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId == null ? null : wxUserId.trim();
    }

    public String getWxUserPhone() {
        return wxUserPhone;
    }

    public void setWxUserPhone(String wxUserPhone) {
        this.wxUserPhone = wxUserPhone == null ? null : wxUserPhone.trim();
    }

    public String getWxUserQuestionImg() {
        return wxUserQuestionImg;
    }

    public void setWxUserQuestionImg(String wxUserQuestionImg) {
        this.wxUserQuestionImg = wxUserQuestionImg == null ? null : wxUserQuestionImg.trim();
    }

    public String getWxUserQuestionTitle() {
        return wxUserQuestionTitle;
    }

    public void setWxUserQuestionTitle(String wxUserQuestionTitle) {
        this.wxUserQuestionTitle = wxUserQuestionTitle == null ? null : wxUserQuestionTitle.trim();
    }

    public String getWxUserQuestionType() {
        return wxUserQuestionType;
    }

    public void setWxUserQuestionType(String wxUserQuestionType) {
        this.wxUserQuestionType = wxUserQuestionType == null ? null : wxUserQuestionType.trim();
    }

    public String getReplyQuestionImg() {
        return replyQuestionImg;
    }

    public void setReplyQuestionImg(String replyQuestionImg) {
        this.replyQuestionImg = replyQuestionImg == null ? null : replyQuestionImg.trim();
    }

    public String getReplyQuestionHuman() {
        return replyQuestionHuman;
    }

    public void setReplyQuestionHuman(String replyQuestionHuman) {
        this.replyQuestionHuman = replyQuestionHuman == null ? null : replyQuestionHuman.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCompletetime() {
        return completetime;
    }

    public void setCompletetime(String completetime) {
        this.completetime = completetime == null ? null : completetime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}