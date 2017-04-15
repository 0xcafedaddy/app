package com.uflowertv.statistics.model;

import java.util.ArrayList;
import java.util.List;

public class DevicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevicesExample() {
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

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andSwversionIsNull() {
            addCriterion("swVersion is null");
            return (Criteria) this;
        }

        public Criteria andSwversionIsNotNull() {
            addCriterion("swVersion is not null");
            return (Criteria) this;
        }

        public Criteria andSwversionEqualTo(String value) {
            addCriterion("swVersion =", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionNotEqualTo(String value) {
            addCriterion("swVersion <>", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionGreaterThan(String value) {
            addCriterion("swVersion >", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionGreaterThanOrEqualTo(String value) {
            addCriterion("swVersion >=", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionLessThan(String value) {
            addCriterion("swVersion <", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionLessThanOrEqualTo(String value) {
            addCriterion("swVersion <=", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionLike(String value) {
            addCriterion("swVersion like", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionNotLike(String value) {
            addCriterion("swVersion not like", value, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionIn(List<String> values) {
            addCriterion("swVersion in", values, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionNotIn(List<String> values) {
            addCriterion("swVersion not in", values, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionBetween(String value1, String value2) {
            addCriterion("swVersion between", value1, value2, "swversion");
            return (Criteria) this;
        }

        public Criteria andSwversionNotBetween(String value1, String value2) {
            addCriterion("swVersion not between", value1, value2, "swversion");
            return (Criteria) this;
        }

        public Criteria andDevicesystemIsNull() {
            addCriterion("deviceSystem is null");
            return (Criteria) this;
        }

        public Criteria andDevicesystemIsNotNull() {
            addCriterion("deviceSystem is not null");
            return (Criteria) this;
        }

        public Criteria andDevicesystemEqualTo(String value) {
            addCriterion("deviceSystem =", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemNotEqualTo(String value) {
            addCriterion("deviceSystem <>", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemGreaterThan(String value) {
            addCriterion("deviceSystem >", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemGreaterThanOrEqualTo(String value) {
            addCriterion("deviceSystem >=", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemLessThan(String value) {
            addCriterion("deviceSystem <", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemLessThanOrEqualTo(String value) {
            addCriterion("deviceSystem <=", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemLike(String value) {
            addCriterion("deviceSystem like", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemNotLike(String value) {
            addCriterion("deviceSystem not like", value, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemIn(List<String> values) {
            addCriterion("deviceSystem in", values, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemNotIn(List<String> values) {
            addCriterion("deviceSystem not in", values, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemBetween(String value1, String value2) {
            addCriterion("deviceSystem between", value1, value2, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andDevicesystemNotBetween(String value1, String value2) {
            addCriterion("deviceSystem not between", value1, value2, "devicesystem");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceIsNull() {
            addCriterion("buildDevice is null");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceIsNotNull() {
            addCriterion("buildDevice is not null");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceEqualTo(String value) {
            addCriterion("buildDevice =", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceNotEqualTo(String value) {
            addCriterion("buildDevice <>", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceGreaterThan(String value) {
            addCriterion("buildDevice >", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceGreaterThanOrEqualTo(String value) {
            addCriterion("buildDevice >=", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceLessThan(String value) {
            addCriterion("buildDevice <", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceLessThanOrEqualTo(String value) {
            addCriterion("buildDevice <=", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceLike(String value) {
            addCriterion("buildDevice like", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceNotLike(String value) {
            addCriterion("buildDevice not like", value, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceIn(List<String> values) {
            addCriterion("buildDevice in", values, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceNotIn(List<String> values) {
            addCriterion("buildDevice not in", values, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceBetween(String value1, String value2) {
            addCriterion("buildDevice between", value1, value2, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuilddeviceNotBetween(String value1, String value2) {
            addCriterion("buildDevice not between", value1, value2, "builddevice");
            return (Criteria) this;
        }

        public Criteria andBuildidIsNull() {
            addCriterion("buildID is null");
            return (Criteria) this;
        }

        public Criteria andBuildidIsNotNull() {
            addCriterion("buildID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildidEqualTo(String value) {
            addCriterion("buildID =", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotEqualTo(String value) {
            addCriterion("buildID <>", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidGreaterThan(String value) {
            addCriterion("buildID >", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidGreaterThanOrEqualTo(String value) {
            addCriterion("buildID >=", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidLessThan(String value) {
            addCriterion("buildID <", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidLessThanOrEqualTo(String value) {
            addCriterion("buildID <=", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidLike(String value) {
            addCriterion("buildID like", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotLike(String value) {
            addCriterion("buildID not like", value, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidIn(List<String> values) {
            addCriterion("buildID in", values, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotIn(List<String> values) {
            addCriterion("buildID not in", values, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidBetween(String value1, String value2) {
            addCriterion("buildID between", value1, value2, "buildid");
            return (Criteria) this;
        }

        public Criteria andBuildidNotBetween(String value1, String value2) {
            addCriterion("buildID not between", value1, value2, "buildid");
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