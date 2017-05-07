package com.wjs.schedule.domain.auth;

import java.util.ArrayList;
import java.util.List;

public class CuckooAuthJobgrpCriteria {
    /**
     * cuckoo_auth_jobgrp表的操作属性:orderByClause
     * 
     */
    protected String orderByClause;

    /**
     * cuckoo_auth_jobgrp表的操作属性:start
     * 
     */
    protected int start;

    /**
     * cuckoo_auth_jobgrp表的操作属性:limit
     * 
     */
    protected int limit;

    /**
     * cuckoo_auth_jobgrp表的操作属性:distinct
     * 
     */
    protected boolean distinct;

    /**
     * cuckoo_auth_jobgrp表的操作属性:oredCriteria
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: CuckooAuthJobgrpCriteria  
     * 
     */
    public CuckooAuthJobgrpCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: setOrderByClause  
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: getOrderByClause  
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: setStart  
     * 
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: getStart  
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: setLimit  
     * 
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: getLimit  
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: setDistinct  
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: isDistinct  
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: getOredCriteria  
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: or  
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: or  
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: createCriteria  
     * 
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: createCriteriaInternal  
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * cuckoo_auth_jobgrp数据表的操作方法: clear  
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * cuckoo_auth_jobgrp表的操作类
     * 
     */
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWritableIsNull() {
            addCriterion("writable is null");
            return (Criteria) this;
        }

        public Criteria andWritableIsNotNull() {
            addCriterion("writable is not null");
            return (Criteria) this;
        }

        public Criteria andWritableEqualTo(String value) {
            addCriterion("writable =", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableNotEqualTo(String value) {
            addCriterion("writable <>", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableGreaterThan(String value) {
            addCriterion("writable >", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableGreaterThanOrEqualTo(String value) {
            addCriterion("writable >=", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableLessThan(String value) {
            addCriterion("writable <", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableLessThanOrEqualTo(String value) {
            addCriterion("writable <=", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableLike(String value) {
            addCriterion("writable like", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableNotLike(String value) {
            addCriterion("writable not like", value, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableIn(List<String> values) {
            addCriterion("writable in", values, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableNotIn(List<String> values) {
            addCriterion("writable not in", values, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableBetween(String value1, String value2) {
            addCriterion("writable between", value1, value2, "writable");
            return (Criteria) this;
        }

        public Criteria andWritableNotBetween(String value1, String value2) {
            addCriterion("writable not between", value1, value2, "writable");
            return (Criteria) this;
        }

        public Criteria andReadableIsNull() {
            addCriterion("readable is null");
            return (Criteria) this;
        }

        public Criteria andReadableIsNotNull() {
            addCriterion("readable is not null");
            return (Criteria) this;
        }

        public Criteria andReadableEqualTo(String value) {
            addCriterion("readable =", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotEqualTo(String value) {
            addCriterion("readable <>", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableGreaterThan(String value) {
            addCriterion("readable >", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableGreaterThanOrEqualTo(String value) {
            addCriterion("readable >=", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLessThan(String value) {
            addCriterion("readable <", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLessThanOrEqualTo(String value) {
            addCriterion("readable <=", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableLike(String value) {
            addCriterion("readable like", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotLike(String value) {
            addCriterion("readable not like", value, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableIn(List<String> values) {
            addCriterion("readable in", values, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotIn(List<String> values) {
            addCriterion("readable not in", values, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableBetween(String value1, String value2) {
            addCriterion("readable between", value1, value2, "readable");
            return (Criteria) this;
        }

        public Criteria andReadableNotBetween(String value1, String value2) {
            addCriterion("readable not between", value1, value2, "readable");
            return (Criteria) this;
        }

        public Criteria andGrantableIsNull() {
            addCriterion("grantable is null");
            return (Criteria) this;
        }

        public Criteria andGrantableIsNotNull() {
            addCriterion("grantable is not null");
            return (Criteria) this;
        }

        public Criteria andGrantableEqualTo(String value) {
            addCriterion("grantable =", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableNotEqualTo(String value) {
            addCriterion("grantable <>", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableGreaterThan(String value) {
            addCriterion("grantable >", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableGreaterThanOrEqualTo(String value) {
            addCriterion("grantable >=", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableLessThan(String value) {
            addCriterion("grantable <", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableLessThanOrEqualTo(String value) {
            addCriterion("grantable <=", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableLike(String value) {
            addCriterion("grantable like", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableNotLike(String value) {
            addCriterion("grantable not like", value, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableIn(List<String> values) {
            addCriterion("grantable in", values, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableNotIn(List<String> values) {
            addCriterion("grantable not in", values, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableBetween(String value1, String value2) {
            addCriterion("grantable between", value1, value2, "grantable");
            return (Criteria) this;
        }

        public Criteria andGrantableNotBetween(String value1, String value2) {
            addCriterion("grantable not between", value1, value2, "grantable");
            return (Criteria) this;
        }
    }

    /**
     * cuckoo_auth_jobgrp表的操作类
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * cuckoo_auth_jobgrp表的操作类
     * 
     */
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