package com.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class XxjXuedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XxjXuedExample() {
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

        public Criteria andXuedIdIsNull() {
            addCriterion("xued_id is null");
            return (Criteria) this;
        }

        public Criteria andXuedIdIsNotNull() {
            addCriterion("xued_id is not null");
            return (Criteria) this;
        }

        public Criteria andXuedIdEqualTo(Integer value) {
            addCriterion("xued_id =", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdNotEqualTo(Integer value) {
            addCriterion("xued_id <>", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdGreaterThan(Integer value) {
            addCriterion("xued_id >", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("xued_id >=", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdLessThan(Integer value) {
            addCriterion("xued_id <", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdLessThanOrEqualTo(Integer value) {
            addCriterion("xued_id <=", value, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdIn(List<Integer> values) {
            addCriterion("xued_id in", values, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdNotIn(List<Integer> values) {
            addCriterion("xued_id not in", values, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdBetween(Integer value1, Integer value2) {
            addCriterion("xued_id between", value1, value2, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("xued_id not between", value1, value2, "xuedId");
            return (Criteria) this;
        }

        public Criteria andXuedNameIsNull() {
            addCriterion("xued_name is null");
            return (Criteria) this;
        }

        public Criteria andXuedNameIsNotNull() {
            addCriterion("xued_name is not null");
            return (Criteria) this;
        }

        public Criteria andXuedNameEqualTo(String value) {
            addCriterion("xued_name =", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameNotEqualTo(String value) {
            addCriterion("xued_name <>", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameGreaterThan(String value) {
            addCriterion("xued_name >", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameGreaterThanOrEqualTo(String value) {
            addCriterion("xued_name >=", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameLessThan(String value) {
            addCriterion("xued_name <", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameLessThanOrEqualTo(String value) {
            addCriterion("xued_name <=", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameLike(String value) {
            addCriterion("xued_name like", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameNotLike(String value) {
            addCriterion("xued_name not like", value, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameIn(List<String> values) {
            addCriterion("xued_name in", values, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameNotIn(List<String> values) {
            addCriterion("xued_name not in", values, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameBetween(String value1, String value2) {
            addCriterion("xued_name between", value1, value2, "xuedName");
            return (Criteria) this;
        }

        public Criteria andXuedNameNotBetween(String value1, String value2) {
            addCriterion("xued_name not between", value1, value2, "xuedName");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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