package com.wjs.schedule.domain.exec;

import java.util.ArrayList;
import java.util.List;

public class CuckooJobExtendCriteria {
    /**
     * cuckoo_job_extend表的操作属性:orderByClause
     * 
     */
    protected String orderByClause;

    /**
     * cuckoo_job_extend表的操作属性:start
     * 
     */
    protected int start;

    /**
     * cuckoo_job_extend表的操作属性:limit
     * 
     */
    protected int limit;

    /**
     * cuckoo_job_extend表的操作属性:distinct
     * 
     */
    protected boolean distinct;

    /**
     * cuckoo_job_extend表的操作属性:oredCriteria
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * cuckoo_job_extend数据表的操作方法: CuckooJobExtendCriteria  
     * 
     */
    public CuckooJobExtendCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * cuckoo_job_extend数据表的操作方法: setOrderByClause  
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: getOrderByClause  
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: setStart  
     * 
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: getStart  
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: setLimit  
     * 
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: getLimit  
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: setDistinct  
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: isDistinct  
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: getOredCriteria  
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: or  
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * cuckoo_job_extend数据表的操作方法: or  
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: createCriteria  
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
     * cuckoo_job_extend数据表的操作方法: createCriteriaInternal  
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * cuckoo_job_extend数据表的操作方法: clear  
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * cuckoo_job_extend表的操作类
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

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Long value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Long value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Long value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Long value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Long value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Long> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Long> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Long value1, Long value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Long value1, Long value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andEmailListIsNull() {
            addCriterion("email_list is null");
            return (Criteria) this;
        }

        public Criteria andEmailListIsNotNull() {
            addCriterion("email_list is not null");
            return (Criteria) this;
        }

        public Criteria andEmailListEqualTo(String value) {
            addCriterion("email_list =", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListNotEqualTo(String value) {
            addCriterion("email_list <>", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListGreaterThan(String value) {
            addCriterion("email_list >", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListGreaterThanOrEqualTo(String value) {
            addCriterion("email_list >=", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListLessThan(String value) {
            addCriterion("email_list <", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListLessThanOrEqualTo(String value) {
            addCriterion("email_list <=", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListLike(String value) {
            addCriterion("email_list like", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListNotLike(String value) {
            addCriterion("email_list not like", value, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListIn(List<String> values) {
            addCriterion("email_list in", values, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListNotIn(List<String> values) {
            addCriterion("email_list not in", values, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListBetween(String value1, String value2) {
            addCriterion("email_list between", value1, value2, "emailList");
            return (Criteria) this;
        }

        public Criteria andEmailListNotBetween(String value1, String value2) {
            addCriterion("email_list not between", value1, value2, "emailList");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongIsNull() {
            addCriterion("over_time_long is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongIsNotNull() {
            addCriterion("over_time_long is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongEqualTo(Long value) {
            addCriterion("over_time_long =", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongNotEqualTo(Long value) {
            addCriterion("over_time_long <>", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongGreaterThan(Long value) {
            addCriterion("over_time_long >", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongGreaterThanOrEqualTo(Long value) {
            addCriterion("over_time_long >=", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongLessThan(Long value) {
            addCriterion("over_time_long <", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongLessThanOrEqualTo(Long value) {
            addCriterion("over_time_long <=", value, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongIn(List<Long> values) {
            addCriterion("over_time_long in", values, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongNotIn(List<Long> values) {
            addCriterion("over_time_long not in", values, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongBetween(Long value1, Long value2) {
            addCriterion("over_time_long between", value1, value2, "overTimeLong");
            return (Criteria) this;
        }

        public Criteria andOverTimeLongNotBetween(Long value1, Long value2) {
            addCriterion("over_time_long not between", value1, value2, "overTimeLong");
            return (Criteria) this;
        }
    }

    /**
     * cuckoo_job_extend表的操作类
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * cuckoo_job_extend表的操作类
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