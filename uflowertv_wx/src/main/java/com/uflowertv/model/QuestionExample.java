package com.uflowertv.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;
    protected String orderExample;
    private String wxUserQuestionContent;
    private String replyQuestionContent;
    
    
    public String getOrderExample() {
		return orderExample;
	}

	public void setOrderExample(String orderExample) {
		this.orderExample = orderExample;
	}

	public String getWxUserQuestionContent() {
		return wxUserQuestionContent;
	}

	public void setWxUserQuestionContent(String wxUserQuestionContent) {
		this.wxUserQuestionContent = wxUserQuestionContent;
	}

	public String getReplyQuestionContent() {
		return replyQuestionContent;
	}

	public void setReplyQuestionContent(String replyQuestionContent) {
		this.replyQuestionContent = replyQuestionContent;
	}

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWxUserIdIsNull() {
            addCriterion("wx_user_id is null");
            return (Criteria) this;
        }

        public Criteria andWxUserIdIsNotNull() {
            addCriterion("wx_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserIdEqualTo(String value) {
            addCriterion("wx_user_id =", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdNotEqualTo(String value) {
            addCriterion("wx_user_id <>", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdGreaterThan(String value) {
            addCriterion("wx_user_id >", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user_id >=", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdLessThan(String value) {
            addCriterion("wx_user_id <", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdLessThanOrEqualTo(String value) {
            addCriterion("wx_user_id <=", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdLike(String value) {
            addCriterion("wx_user_id like", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdNotLike(String value) {
            addCriterion("wx_user_id not like", value, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdIn(List<String> values) {
            addCriterion("wx_user_id in", values, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdNotIn(List<String> values) {
            addCriterion("wx_user_id not in", values, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdBetween(String value1, String value2) {
            addCriterion("wx_user_id between", value1, value2, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserIdNotBetween(String value1, String value2) {
            addCriterion("wx_user_id not between", value1, value2, "wxUserId");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneIsNull() {
            addCriterion("wx_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneIsNotNull() {
            addCriterion("wx_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneEqualTo(String value) {
            addCriterion("wx_user_phone =", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneNotEqualTo(String value) {
            addCriterion("wx_user_phone <>", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneGreaterThan(String value) {
            addCriterion("wx_user_phone >", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user_phone >=", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneLessThan(String value) {
            addCriterion("wx_user_phone <", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("wx_user_phone <=", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneLike(String value) {
            addCriterion("wx_user_phone like", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneNotLike(String value) {
            addCriterion("wx_user_phone not like", value, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneIn(List<String> values) {
            addCriterion("wx_user_phone in", values, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneNotIn(List<String> values) {
            addCriterion("wx_user_phone not in", values, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneBetween(String value1, String value2) {
            addCriterion("wx_user_phone between", value1, value2, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserPhoneNotBetween(String value1, String value2) {
            addCriterion("wx_user_phone not between", value1, value2, "wxUserPhone");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgIsNull() {
            addCriterion("wx_user_question_img is null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgIsNotNull() {
            addCriterion("wx_user_question_img is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgEqualTo(String value) {
            addCriterion("wx_user_question_img =", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgNotEqualTo(String value) {
            addCriterion("wx_user_question_img <>", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgGreaterThan(String value) {
            addCriterion("wx_user_question_img >", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user_question_img >=", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgLessThan(String value) {
            addCriterion("wx_user_question_img <", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgLessThanOrEqualTo(String value) {
            addCriterion("wx_user_question_img <=", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgLike(String value) {
            addCriterion("wx_user_question_img like", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgNotLike(String value) {
            addCriterion("wx_user_question_img not like", value, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgIn(List<String> values) {
            addCriterion("wx_user_question_img in", values, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgNotIn(List<String> values) {
            addCriterion("wx_user_question_img not in", values, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgBetween(String value1, String value2) {
            addCriterion("wx_user_question_img between", value1, value2, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionImgNotBetween(String value1, String value2) {
            addCriterion("wx_user_question_img not between", value1, value2, "wxUserQuestionImg");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleIsNull() {
            addCriterion("wx_user_question_title is null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleIsNotNull() {
            addCriterion("wx_user_question_title is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleEqualTo(String value) {
            addCriterion("wx_user_question_title =", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleNotEqualTo(String value) {
            addCriterion("wx_user_question_title <>", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleGreaterThan(String value) {
            addCriterion("wx_user_question_title >", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user_question_title >=", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleLessThan(String value) {
            addCriterion("wx_user_question_title <", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleLessThanOrEqualTo(String value) {
            addCriterion("wx_user_question_title <=", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleLike(String value) {
            addCriterion("wx_user_question_title like", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleNotLike(String value) {
            addCriterion("wx_user_question_title not like", value, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleIn(List<String> values) {
            addCriterion("wx_user_question_title in", values, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleNotIn(List<String> values) {
            addCriterion("wx_user_question_title not in", values, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleBetween(String value1, String value2) {
            addCriterion("wx_user_question_title between", value1, value2, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTitleNotBetween(String value1, String value2) {
            addCriterion("wx_user_question_title not between", value1, value2, "wxUserQuestionTitle");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeIsNull() {
            addCriterion("wx_user_question_type is null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeIsNotNull() {
            addCriterion("wx_user_question_type is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeEqualTo(String value) {
            addCriterion("wx_user_question_type =", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeNotEqualTo(String value) {
            addCriterion("wx_user_question_type <>", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeGreaterThan(String value) {
            addCriterion("wx_user_question_type >", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user_question_type >=", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeLessThan(String value) {
            addCriterion("wx_user_question_type <", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("wx_user_question_type <=", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeLike(String value) {
            addCriterion("wx_user_question_type like", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeNotLike(String value) {
            addCriterion("wx_user_question_type not like", value, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeIn(List<String> values) {
            addCriterion("wx_user_question_type in", values, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeNotIn(List<String> values) {
            addCriterion("wx_user_question_type not in", values, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeBetween(String value1, String value2) {
            addCriterion("wx_user_question_type between", value1, value2, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andWxUserQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("wx_user_question_type not between", value1, value2, "wxUserQuestionType");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgIsNull() {
            addCriterion("reply_question_img is null");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgIsNotNull() {
            addCriterion("reply_question_img is not null");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgEqualTo(String value) {
            addCriterion("reply_question_img =", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgNotEqualTo(String value) {
            addCriterion("reply_question_img <>", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgGreaterThan(String value) {
            addCriterion("reply_question_img >", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgGreaterThanOrEqualTo(String value) {
            addCriterion("reply_question_img >=", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgLessThan(String value) {
            addCriterion("reply_question_img <", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgLessThanOrEqualTo(String value) {
            addCriterion("reply_question_img <=", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgLike(String value) {
            addCriterion("reply_question_img like", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgNotLike(String value) {
            addCriterion("reply_question_img not like", value, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgIn(List<String> values) {
            addCriterion("reply_question_img in", values, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgNotIn(List<String> values) {
            addCriterion("reply_question_img not in", values, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgBetween(String value1, String value2) {
            addCriterion("reply_question_img between", value1, value2, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionImgNotBetween(String value1, String value2) {
            addCriterion("reply_question_img not between", value1, value2, "replyQuestionImg");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanIsNull() {
            addCriterion("reply_question_human is null");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanIsNotNull() {
            addCriterion("reply_question_human is not null");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanEqualTo(String value) {
            addCriterion("reply_question_human =", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanNotEqualTo(String value) {
            addCriterion("reply_question_human <>", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanGreaterThan(String value) {
            addCriterion("reply_question_human >", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanGreaterThanOrEqualTo(String value) {
            addCriterion("reply_question_human >=", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanLessThan(String value) {
            addCriterion("reply_question_human <", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanLessThanOrEqualTo(String value) {
            addCriterion("reply_question_human <=", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanLike(String value) {
            addCriterion("reply_question_human like", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanNotLike(String value) {
            addCriterion("reply_question_human not like", value, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanIn(List<String> values) {
            addCriterion("reply_question_human in", values, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanNotIn(List<String> values) {
            addCriterion("reply_question_human not in", values, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanBetween(String value1, String value2) {
            addCriterion("reply_question_human between", value1, value2, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andReplyQuestionHumanNotBetween(String value1, String value2) {
            addCriterion("reply_question_human not between", value1, value2, "replyQuestionHuman");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeIsNull() {
            addCriterion("completeTime is null");
            return (Criteria) this;
        }

        public Criteria andCompletetimeIsNotNull() {
            addCriterion("completeTime is not null");
            return (Criteria) this;
        }

        public Criteria andCompletetimeEqualTo(String value) {
            addCriterion("completeTime =", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotEqualTo(String value) {
            addCriterion("completeTime <>", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeGreaterThan(String value) {
            addCriterion("completeTime >", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeGreaterThanOrEqualTo(String value) {
            addCriterion("completeTime >=", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeLessThan(String value) {
            addCriterion("completeTime <", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeLessThanOrEqualTo(String value) {
            addCriterion("completeTime <=", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeLike(String value) {
            addCriterion("completeTime like", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotLike(String value) {
            addCriterion("completeTime not like", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeIn(List<String> values) {
            addCriterion("completeTime in", values, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotIn(List<String> values) {
            addCriterion("completeTime not in", values, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeBetween(String value1, String value2) {
            addCriterion("completeTime between", value1, value2, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotBetween(String value1, String value2) {
            addCriterion("completeTime not between", value1, value2, "completetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}