package com.uflowertv.statistics.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDtIsNull() {
            addCriterion("dt is null");
            return (Criteria) this;
        }

        public Criteria andDtIsNotNull() {
            addCriterion("dt is not null");
            return (Criteria) this;
        }

        public Criteria andDtEqualTo(Date value) {
            addCriterion("dt =", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotEqualTo(Date value) {
            addCriterion("dt <>", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThan(Date value) {
            addCriterion("dt >", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThanOrEqualTo(Date value) {
            addCriterion("dt >=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThan(Date value) {
            addCriterion("dt <", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThanOrEqualTo(Date value) {
            addCriterion("dt <=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtIn(List<Date> values) {
            addCriterion("dt in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotIn(List<Date> values) {
            addCriterion("dt not in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtBetween(Date value1, Date value2) {
            addCriterion("dt between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotBetween(Date value1, Date value2) {
            addCriterion("dt not between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andPlatformidIsNull() {
            addCriterion("platformID is null");
            return (Criteria) this;
        }

        public Criteria andPlatformidIsNotNull() {
            addCriterion("platformID is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformidEqualTo(Integer value) {
            addCriterion("platformID =", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotEqualTo(Integer value) {
            addCriterion("platformID <>", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidGreaterThan(Integer value) {
            addCriterion("platformID >", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformID >=", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidLessThan(Integer value) {
            addCriterion("platformID <", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidLessThanOrEqualTo(Integer value) {
            addCriterion("platformID <=", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidIn(List<Integer> values) {
            addCriterion("platformID in", values, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotIn(List<Integer> values) {
            addCriterion("platformID not in", values, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidBetween(Integer value1, Integer value2) {
            addCriterion("platformID between", value1, value2, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotBetween(Integer value1, Integer value2) {
            addCriterion("platformID not between", value1, value2, "platformid");
            return (Criteria) this;
        }

        public Criteria andZoneidIsNull() {
            addCriterion("zoneID is null");
            return (Criteria) this;
        }

        public Criteria andZoneidIsNotNull() {
            addCriterion("zoneID is not null");
            return (Criteria) this;
        }

        public Criteria andZoneidEqualTo(String value) {
            addCriterion("zoneID =", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotEqualTo(String value) {
            addCriterion("zoneID <>", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidGreaterThan(String value) {
            addCriterion("zoneID >", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidGreaterThanOrEqualTo(String value) {
            addCriterion("zoneID >=", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidLessThan(String value) {
            addCriterion("zoneID <", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidLessThanOrEqualTo(String value) {
            addCriterion("zoneID <=", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidLike(String value) {
            addCriterion("zoneID like", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotLike(String value) {
            addCriterion("zoneID not like", value, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidIn(List<String> values) {
            addCriterion("zoneID in", values, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotIn(List<String> values) {
            addCriterion("zoneID not in", values, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidBetween(String value1, String value2) {
            addCriterion("zoneID between", value1, value2, "zoneid");
            return (Criteria) this;
        }

        public Criteria andZoneidNotBetween(String value1, String value2) {
            addCriterion("zoneID not between", value1, value2, "zoneid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceID =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceID <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceID >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceID >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceID <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceID <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceID like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceID not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceID in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceID not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceID between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceID not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNull() {
            addCriterion("indexID is null");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNotNull() {
            addCriterion("indexID is not null");
            return (Criteria) this;
        }

        public Criteria andIndexidEqualTo(Integer value) {
            addCriterion("indexID =", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotEqualTo(Integer value) {
            addCriterion("indexID <>", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThan(Integer value) {
            addCriterion("indexID >", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThanOrEqualTo(Integer value) {
            addCriterion("indexID >=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThan(Integer value) {
            addCriterion("indexID <", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThanOrEqualTo(Integer value) {
            addCriterion("indexID <=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidIn(List<Integer> values) {
            addCriterion("indexID in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotIn(List<Integer> values) {
            addCriterion("indexID not in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidBetween(Integer value1, Integer value2) {
            addCriterion("indexID between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotBetween(Integer value1, Integer value2) {
            addCriterion("indexID not between", value1, value2, "indexid");
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