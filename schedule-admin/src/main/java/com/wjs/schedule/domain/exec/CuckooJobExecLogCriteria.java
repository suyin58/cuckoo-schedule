package com.wjs.schedule.domain.exec;

import java.util.ArrayList;
import java.util.List;

public class CuckooJobExecLogCriteria {
    /**
     * cuckoo_job_exec_log表的操作属性:orderByClause
     * 
     */
    protected String orderByClause;

    /**
     * cuckoo_job_exec_log表的操作属性:start
     * 
     */
    protected int start;

    /**
     * cuckoo_job_exec_log表的操作属性:limit
     * 
     */
    protected int limit;

    /**
     * cuckoo_job_exec_log表的操作属性:distinct
     * 
     */
    protected boolean distinct;

    /**
     * cuckoo_job_exec_log表的操作属性:oredCriteria
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * cuckoo_job_exec_log数据表的操作方法: CuckooJobExecLogCriteria  
     * 
     */
    public CuckooJobExecLogCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: setOrderByClause  
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: getOrderByClause  
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: setStart  
     * 
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: getStart  
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: setLimit  
     * 
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: getLimit  
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: setDistinct  
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: isDistinct  
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: getOredCriteria  
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: or  
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: or  
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: createCriteria  
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
     * cuckoo_job_exec_log数据表的操作方法: createCriteriaInternal  
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * cuckoo_job_exec_log数据表的操作方法: clear  
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * cuckoo_job_exec_log表的操作类
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

        public Criteria andExecJobTypeIsNull() {
            addCriterion("exec_job_type is null");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeIsNotNull() {
            addCriterion("exec_job_type is not null");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeEqualTo(String value) {
            addCriterion("exec_job_type =", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeNotEqualTo(String value) {
            addCriterion("exec_job_type <>", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeGreaterThan(String value) {
            addCriterion("exec_job_type >", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exec_job_type >=", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeLessThan(String value) {
            addCriterion("exec_job_type <", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeLessThanOrEqualTo(String value) {
            addCriterion("exec_job_type <=", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeLike(String value) {
            addCriterion("exec_job_type like", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeNotLike(String value) {
            addCriterion("exec_job_type not like", value, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeIn(List<String> values) {
            addCriterion("exec_job_type in", values, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeNotIn(List<String> values) {
            addCriterion("exec_job_type not in", values, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeBetween(String value1, String value2) {
            addCriterion("exec_job_type between", value1, value2, "execJobType");
            return (Criteria) this;
        }

        public Criteria andExecJobTypeNotBetween(String value1, String value2) {
            addCriterion("exec_job_type not between", value1, value2, "execJobType");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationIsNull() {
            addCriterion("job_class_application is null");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationIsNotNull() {
            addCriterion("job_class_application is not null");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationEqualTo(String value) {
            addCriterion("job_class_application =", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationNotEqualTo(String value) {
            addCriterion("job_class_application <>", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationGreaterThan(String value) {
            addCriterion("job_class_application >", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("job_class_application >=", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationLessThan(String value) {
            addCriterion("job_class_application <", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationLessThanOrEqualTo(String value) {
            addCriterion("job_class_application <=", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationLike(String value) {
            addCriterion("job_class_application like", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationNotLike(String value) {
            addCriterion("job_class_application not like", value, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationIn(List<String> values) {
            addCriterion("job_class_application in", values, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationNotIn(List<String> values) {
            addCriterion("job_class_application not in", values, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationBetween(String value1, String value2) {
            addCriterion("job_class_application between", value1, value2, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobClassApplicationNotBetween(String value1, String value2) {
            addCriterion("job_class_application not between", value1, value2, "jobClassApplication");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNull() {
            addCriterion("trigger_type is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNotNull() {
            addCriterion("trigger_type is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeEqualTo(String value) {
            addCriterion("trigger_type =", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotEqualTo(String value) {
            addCriterion("trigger_type <>", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThan(String value) {
            addCriterion("trigger_type >", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_type >=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThan(String value) {
            addCriterion("trigger_type <", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThanOrEqualTo(String value) {
            addCriterion("trigger_type <=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLike(String value) {
            addCriterion("trigger_type like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotLike(String value) {
            addCriterion("trigger_type not like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIn(List<String> values) {
            addCriterion("trigger_type in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotIn(List<String> values) {
            addCriterion("trigger_type not in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeBetween(String value1, String value2) {
            addCriterion("trigger_type between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotBetween(String value1, String value2) {
            addCriterion("trigger_type not between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTypeDailyIsNull() {
            addCriterion("type_daily is null");
            return (Criteria) this;
        }

        public Criteria andTypeDailyIsNotNull() {
            addCriterion("type_daily is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDailyEqualTo(String value) {
            addCriterion("type_daily =", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyNotEqualTo(String value) {
            addCriterion("type_daily <>", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyGreaterThan(String value) {
            addCriterion("type_daily >", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyGreaterThanOrEqualTo(String value) {
            addCriterion("type_daily >=", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyLessThan(String value) {
            addCriterion("type_daily <", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyLessThanOrEqualTo(String value) {
            addCriterion("type_daily <=", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyLike(String value) {
            addCriterion("type_daily like", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyNotLike(String value) {
            addCriterion("type_daily not like", value, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyIn(List<String> values) {
            addCriterion("type_daily in", values, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyNotIn(List<String> values) {
            addCriterion("type_daily not in", values, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyBetween(String value1, String value2) {
            addCriterion("type_daily between", value1, value2, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andTypeDailyNotBetween(String value1, String value2) {
            addCriterion("type_daily not between", value1, value2, "typeDaily");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("cron_expression is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("cron_expression is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("cron_expression =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("cron_expression <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("cron_expression >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cron_expression >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("cron_expression <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("cron_expression <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("cron_expression like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("cron_expression not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("cron_expression in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("cron_expression not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("cron_expression between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("cron_expression not between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNull() {
            addCriterion("tx_date is null");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNotNull() {
            addCriterion("tx_date is not null");
            return (Criteria) this;
        }

        public Criteria andTxDateEqualTo(Integer value) {
            addCriterion("tx_date =", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotEqualTo(Integer value) {
            addCriterion("tx_date <>", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThan(Integer value) {
            addCriterion("tx_date >", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("tx_date >=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThan(Integer value) {
            addCriterion("tx_date <", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThanOrEqualTo(Integer value) {
            addCriterion("tx_date <=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateIn(List<Integer> values) {
            addCriterion("tx_date in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotIn(List<Integer> values) {
            addCriterion("tx_date not in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateBetween(Integer value1, Integer value2) {
            addCriterion("tx_date between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotBetween(Integer value1, Integer value2) {
            addCriterion("tx_date not between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeIsNull() {
            addCriterion("flow_last_time is null");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeIsNotNull() {
            addCriterion("flow_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeEqualTo(Long value) {
            addCriterion("flow_last_time =", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeNotEqualTo(Long value) {
            addCriterion("flow_last_time <>", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeGreaterThan(Long value) {
            addCriterion("flow_last_time >", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("flow_last_time >=", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeLessThan(Long value) {
            addCriterion("flow_last_time <", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeLessThanOrEqualTo(Long value) {
            addCriterion("flow_last_time <=", value, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeIn(List<Long> values) {
            addCriterion("flow_last_time in", values, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeNotIn(List<Long> values) {
            addCriterion("flow_last_time not in", values, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeBetween(Long value1, Long value2) {
            addCriterion("flow_last_time between", value1, value2, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowLastTimeNotBetween(Long value1, Long value2) {
            addCriterion("flow_last_time not between", value1, value2, "flowLastTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeIsNull() {
            addCriterion("flow_cur_time is null");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeIsNotNull() {
            addCriterion("flow_cur_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeEqualTo(Long value) {
            addCriterion("flow_cur_time =", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeNotEqualTo(Long value) {
            addCriterion("flow_cur_time <>", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeGreaterThan(Long value) {
            addCriterion("flow_cur_time >", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("flow_cur_time >=", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeLessThan(Long value) {
            addCriterion("flow_cur_time <", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeLessThanOrEqualTo(Long value) {
            addCriterion("flow_cur_time <=", value, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeIn(List<Long> values) {
            addCriterion("flow_cur_time in", values, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeNotIn(List<Long> values) {
            addCriterion("flow_cur_time not in", values, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeBetween(Long value1, Long value2) {
            addCriterion("flow_cur_time between", value1, value2, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andFlowCurTimeNotBetween(Long value1, Long value2) {
            addCriterion("flow_cur_time not between", value1, value2, "flowCurTime");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsIsNull() {
            addCriterion("cuckoo_parallel_job_args is null");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsIsNotNull() {
            addCriterion("cuckoo_parallel_job_args is not null");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsEqualTo(String value) {
            addCriterion("cuckoo_parallel_job_args =", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsNotEqualTo(String value) {
            addCriterion("cuckoo_parallel_job_args <>", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsGreaterThan(String value) {
            addCriterion("cuckoo_parallel_job_args >", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsGreaterThanOrEqualTo(String value) {
            addCriterion("cuckoo_parallel_job_args >=", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsLessThan(String value) {
            addCriterion("cuckoo_parallel_job_args <", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsLessThanOrEqualTo(String value) {
            addCriterion("cuckoo_parallel_job_args <=", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsLike(String value) {
            addCriterion("cuckoo_parallel_job_args like", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsNotLike(String value) {
            addCriterion("cuckoo_parallel_job_args not like", value, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsIn(List<String> values) {
            addCriterion("cuckoo_parallel_job_args in", values, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsNotIn(List<String> values) {
            addCriterion("cuckoo_parallel_job_args not in", values, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsBetween(String value1, String value2) {
            addCriterion("cuckoo_parallel_job_args between", value1, value2, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andCuckooParallelJobArgsNotBetween(String value1, String value2) {
            addCriterion("cuckoo_parallel_job_args not between", value1, value2, "cuckooParallelJobArgs");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIsNull() {
            addCriterion("job_start_time is null");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIsNotNull() {
            addCriterion("job_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeEqualTo(Long value) {
            addCriterion("job_start_time =", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotEqualTo(Long value) {
            addCriterion("job_start_time <>", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeGreaterThan(Long value) {
            addCriterion("job_start_time >", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("job_start_time >=", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeLessThan(Long value) {
            addCriterion("job_start_time <", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("job_start_time <=", value, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeIn(List<Long> values) {
            addCriterion("job_start_time in", values, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotIn(List<Long> values) {
            addCriterion("job_start_time not in", values, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeBetween(Long value1, Long value2) {
            addCriterion("job_start_time between", value1, value2, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("job_start_time not between", value1, value2, "jobStartTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeIsNull() {
            addCriterion("job_exec_time is null");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeIsNotNull() {
            addCriterion("job_exec_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeEqualTo(Long value) {
            addCriterion("job_exec_time =", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeNotEqualTo(Long value) {
            addCriterion("job_exec_time <>", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeGreaterThan(Long value) {
            addCriterion("job_exec_time >", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("job_exec_time >=", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeLessThan(Long value) {
            addCriterion("job_exec_time <", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeLessThanOrEqualTo(Long value) {
            addCriterion("job_exec_time <=", value, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeIn(List<Long> values) {
            addCriterion("job_exec_time in", values, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeNotIn(List<Long> values) {
            addCriterion("job_exec_time not in", values, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeBetween(Long value1, Long value2) {
            addCriterion("job_exec_time between", value1, value2, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobExecTimeNotBetween(Long value1, Long value2) {
            addCriterion("job_exec_time not between", value1, value2, "jobExecTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIsNull() {
            addCriterion("job_end_time is null");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIsNotNull() {
            addCriterion("job_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeEqualTo(Long value) {
            addCriterion("job_end_time =", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotEqualTo(Long value) {
            addCriterion("job_end_time <>", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeGreaterThan(Long value) {
            addCriterion("job_end_time >", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("job_end_time >=", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeLessThan(Long value) {
            addCriterion("job_end_time <", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("job_end_time <=", value, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeIn(List<Long> values) {
            addCriterion("job_end_time in", values, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotIn(List<Long> values) {
            addCriterion("job_end_time not in", values, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeBetween(Long value1, Long value2) {
            addCriterion("job_end_time between", value1, value2, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andJobEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("job_end_time not between", value1, value2, "jobEndTime");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusIsNull() {
            addCriterion("exec_job_status is null");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusIsNotNull() {
            addCriterion("exec_job_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusEqualTo(String value) {
            addCriterion("exec_job_status =", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusNotEqualTo(String value) {
            addCriterion("exec_job_status <>", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusGreaterThan(String value) {
            addCriterion("exec_job_status >", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusGreaterThanOrEqualTo(String value) {
            addCriterion("exec_job_status >=", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusLessThan(String value) {
            addCriterion("exec_job_status <", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusLessThanOrEqualTo(String value) {
            addCriterion("exec_job_status <=", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusLike(String value) {
            addCriterion("exec_job_status like", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusNotLike(String value) {
            addCriterion("exec_job_status not like", value, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusIn(List<String> values) {
            addCriterion("exec_job_status in", values, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusNotIn(List<String> values) {
            addCriterion("exec_job_status not in", values, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusBetween(String value1, String value2) {
            addCriterion("exec_job_status between", value1, value2, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andExecJobStatusNotBetween(String value1, String value2) {
            addCriterion("exec_job_status not between", value1, value2, "execJobStatus");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpIsNull() {
            addCriterion("cuckoo_client_ip is null");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpIsNotNull() {
            addCriterion("cuckoo_client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpEqualTo(String value) {
            addCriterion("cuckoo_client_ip =", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpNotEqualTo(String value) {
            addCriterion("cuckoo_client_ip <>", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpGreaterThan(String value) {
            addCriterion("cuckoo_client_ip >", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("cuckoo_client_ip >=", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpLessThan(String value) {
            addCriterion("cuckoo_client_ip <", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpLessThanOrEqualTo(String value) {
            addCriterion("cuckoo_client_ip <=", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpLike(String value) {
            addCriterion("cuckoo_client_ip like", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpNotLike(String value) {
            addCriterion("cuckoo_client_ip not like", value, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpIn(List<String> values) {
            addCriterion("cuckoo_client_ip in", values, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpNotIn(List<String> values) {
            addCriterion("cuckoo_client_ip not in", values, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpBetween(String value1, String value2) {
            addCriterion("cuckoo_client_ip between", value1, value2, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientIpNotBetween(String value1, String value2) {
            addCriterion("cuckoo_client_ip not between", value1, value2, "cuckooClientIp");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortIsNull() {
            addCriterion("cuckoo_client_port is null");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortIsNotNull() {
            addCriterion("cuckoo_client_port is not null");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortEqualTo(Integer value) {
            addCriterion("cuckoo_client_port =", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortNotEqualTo(Integer value) {
            addCriterion("cuckoo_client_port <>", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortGreaterThan(Integer value) {
            addCriterion("cuckoo_client_port >", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("cuckoo_client_port >=", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortLessThan(Integer value) {
            addCriterion("cuckoo_client_port <", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortLessThanOrEqualTo(Integer value) {
            addCriterion("cuckoo_client_port <=", value, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortIn(List<Integer> values) {
            addCriterion("cuckoo_client_port in", values, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortNotIn(List<Integer> values) {
            addCriterion("cuckoo_client_port not in", values, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortBetween(Integer value1, Integer value2) {
            addCriterion("cuckoo_client_port between", value1, value2, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andCuckooClientPortNotBetween(Integer value1, Integer value2) {
            addCriterion("cuckoo_client_port not between", value1, value2, "cuckooClientPort");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeIsNull() {
            addCriterion("latest_check_time is null");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeIsNotNull() {
            addCriterion("latest_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeEqualTo(Long value) {
            addCriterion("latest_check_time =", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeNotEqualTo(Long value) {
            addCriterion("latest_check_time <>", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeGreaterThan(Long value) {
            addCriterion("latest_check_time >", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("latest_check_time >=", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeLessThan(Long value) {
            addCriterion("latest_check_time <", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeLessThanOrEqualTo(Long value) {
            addCriterion("latest_check_time <=", value, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeIn(List<Long> values) {
            addCriterion("latest_check_time in", values, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeNotIn(List<Long> values) {
            addCriterion("latest_check_time not in", values, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeBetween(Long value1, Long value2) {
            addCriterion("latest_check_time between", value1, value2, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andLatestCheckTimeNotBetween(Long value1, Long value2) {
            addCriterion("latest_check_time not between", value1, value2, "latestCheckTime");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextIsNull() {
            addCriterion("need_triggle_next is null");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextIsNotNull() {
            addCriterion("need_triggle_next is not null");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextEqualTo(Boolean value) {
            addCriterion("need_triggle_next =", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextNotEqualTo(Boolean value) {
            addCriterion("need_triggle_next <>", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextGreaterThan(Boolean value) {
            addCriterion("need_triggle_next >", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_triggle_next >=", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextLessThan(Boolean value) {
            addCriterion("need_triggle_next <", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextLessThanOrEqualTo(Boolean value) {
            addCriterion("need_triggle_next <=", value, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextIn(List<Boolean> values) {
            addCriterion("need_triggle_next in", values, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextNotIn(List<Boolean> values) {
            addCriterion("need_triggle_next not in", values, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextBetween(Boolean value1, Boolean value2) {
            addCriterion("need_triggle_next between", value1, value2, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andNeedTriggleNextNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_triggle_next not between", value1, value2, "needTriggleNext");
            return (Criteria) this;
        }

        public Criteria andForceTriggleIsNull() {
            addCriterion("force_triggle is null");
            return (Criteria) this;
        }

        public Criteria andForceTriggleIsNotNull() {
            addCriterion("force_triggle is not null");
            return (Criteria) this;
        }

        public Criteria andForceTriggleEqualTo(Boolean value) {
            addCriterion("force_triggle =", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleNotEqualTo(Boolean value) {
            addCriterion("force_triggle <>", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleGreaterThan(Boolean value) {
            addCriterion("force_triggle >", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("force_triggle >=", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleLessThan(Boolean value) {
            addCriterion("force_triggle <", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleLessThanOrEqualTo(Boolean value) {
            addCriterion("force_triggle <=", value, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleIn(List<Boolean> values) {
            addCriterion("force_triggle in", values, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleNotIn(List<Boolean> values) {
            addCriterion("force_triggle not in", values, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleBetween(Boolean value1, Boolean value2) {
            addCriterion("force_triggle between", value1, value2, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andForceTriggleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("force_triggle not between", value1, value2, "forceTriggle");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * cuckoo_job_exec_log表的操作类
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * cuckoo_job_exec_log表的操作类
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