package com.uflowertv.model;

public class QuestionWithBLOBs extends Question {
    private String wxUserQuestionContent;

    private String replyQuestionContent;

    public String getWxUserQuestionContent() {
        return wxUserQuestionContent;
    }

    public void setWxUserQuestionContent(String wxUserQuestionContent) {
        this.wxUserQuestionContent = wxUserQuestionContent == null ? null : wxUserQuestionContent.trim();
    }

    public String getReplyQuestionContent() {
        return replyQuestionContent;
    }

    public void setReplyQuestionContent(String replyQuestionContent) {
        this.replyQuestionContent = replyQuestionContent == null ? null : replyQuestionContent.trim();
    }
}