package cn.edu.gdin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportdataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportdataExample() {
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

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collection_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collection_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Date value) {
            addCriterion("collection_time =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Date value) {
            addCriterion("collection_time <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Date value) {
            addCriterion("collection_time >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collection_time >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Date value) {
            addCriterion("collection_time <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("collection_time <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Date> values) {
            addCriterion("collection_time in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Date> values) {
            addCriterion("collection_time not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Date value1, Date value2) {
            addCriterion("collection_time between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("collection_time not between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andKilometersIsNull() {
            addCriterion("kilometers is null");
            return (Criteria) this;
        }

        public Criteria andKilometersIsNotNull() {
            addCriterion("kilometers is not null");
            return (Criteria) this;
        }

        public Criteria andKilometersEqualTo(Integer value) {
            addCriterion("kilometers =", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersNotEqualTo(Integer value) {
            addCriterion("kilometers <>", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersGreaterThan(Integer value) {
            addCriterion("kilometers >", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersGreaterThanOrEqualTo(Integer value) {
            addCriterion("kilometers >=", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersLessThan(Integer value) {
            addCriterion("kilometers <", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersLessThanOrEqualTo(Integer value) {
            addCriterion("kilometers <=", value, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersIn(List<Integer> values) {
            addCriterion("kilometers in", values, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersNotIn(List<Integer> values) {
            addCriterion("kilometers not in", values, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersBetween(Integer value1, Integer value2) {
            addCriterion("kilometers between", value1, value2, "kilometers");
            return (Criteria) this;
        }

        public Criteria andKilometersNotBetween(Integer value1, Integer value2) {
            addCriterion("kilometers not between", value1, value2, "kilometers");
            return (Criteria) this;
        }

        public Criteria andLightSleepIsNull() {
            addCriterion("light_sleep is null");
            return (Criteria) this;
        }

        public Criteria andLightSleepIsNotNull() {
            addCriterion("light_sleep is not null");
            return (Criteria) this;
        }

        public Criteria andLightSleepEqualTo(Short value) {
            addCriterion("light_sleep =", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotEqualTo(Short value) {
            addCriterion("light_sleep <>", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepGreaterThan(Short value) {
            addCriterion("light_sleep >", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepGreaterThanOrEqualTo(Short value) {
            addCriterion("light_sleep >=", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepLessThan(Short value) {
            addCriterion("light_sleep <", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepLessThanOrEqualTo(Short value) {
            addCriterion("light_sleep <=", value, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepIn(List<Short> values) {
            addCriterion("light_sleep in", values, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotIn(List<Short> values) {
            addCriterion("light_sleep not in", values, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepBetween(Short value1, Short value2) {
            addCriterion("light_sleep between", value1, value2, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andLightSleepNotBetween(Short value1, Short value2) {
            addCriterion("light_sleep not between", value1, value2, "lightSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIsNull() {
            addCriterion("deep_sleep is null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIsNotNull() {
            addCriterion("deep_sleep is not null");
            return (Criteria) this;
        }

        public Criteria andDeepSleepEqualTo(Short value) {
            addCriterion("deep_sleep =", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotEqualTo(Short value) {
            addCriterion("deep_sleep <>", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepGreaterThan(Short value) {
            addCriterion("deep_sleep >", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepGreaterThanOrEqualTo(Short value) {
            addCriterion("deep_sleep >=", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepLessThan(Short value) {
            addCriterion("deep_sleep <", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepLessThanOrEqualTo(Short value) {
            addCriterion("deep_sleep <=", value, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepIn(List<Short> values) {
            addCriterion("deep_sleep in", values, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotIn(List<Short> values) {
            addCriterion("deep_sleep not in", values, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepBetween(Short value1, Short value2) {
            addCriterion("deep_sleep between", value1, value2, "deepSleep");
            return (Criteria) this;
        }

        public Criteria andDeepSleepNotBetween(Short value1, Short value2) {
            addCriterion("deep_sleep not between", value1, value2, "deepSleep");
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