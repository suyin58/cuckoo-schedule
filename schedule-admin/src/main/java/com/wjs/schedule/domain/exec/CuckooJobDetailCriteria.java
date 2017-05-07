package com.wjs.schedule.domain.exec;

import java.util.ArrayList;
import java.util.List;

public class CuckooJobDetailCriteria {
    /**
     * cuckoo_job_detail表的操作属性:orderByClause
     * 
     */
    protected String orderByClause;

    /**
     * cuckoo_job_detail表的操作属性:start
     * 
     */
    protected int start;

    /**
     * cuckoo_job_detail表的操作属性:limit
     * 
     */
    protected int limit;

    /**
     * cuckoo_job_detail表的操作属性:distinct
     * 
     */
    protected boolean distinct;

    /**
     * cuckoo_job_detail表的操作属性:oredCriteria
     * 
     */
    protected List<Criteria> oredCriteria;

    /**
     * cuckoo_job_detail数据表的操作方法: CuckooJobDetailCriteria  
     * 
     */
    public CuckooJobDetailCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * cuckoo_job_detail数据表的操作方法: setOrderByClause  
     * 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: getOrderByClause  
     * 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: setStart  
     * 
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: getStart  
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: setLimit  
     * 
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: getLimit  
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: setDistinct  
     * 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: isDistinct  
     * 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: getOredCriteria  
     * 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: or  
     * 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * cuckoo_job_detail数据表的操作方法: or  
     * 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: createCriteria  
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
     * cuckoo_job_detail数据表的操作方法: createCriteriaInternal  
     * 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * cuckoo_job_detail数据表的操作方法: clear  
     * 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * cuckoo_job_detail表的操作类
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

        public Criteria andJobDescIsNull() {
            addCriterion("job_desc is null");
            return (Criteria) this;
        }

        public Criteria andJobDescIsNotNull() {
            addCriterion("job_desc is not null");
            return (Criteria) this;
        }

        public Criteria andJobDescEqualTo(String value) {
            addCriterion("job_desc =", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotEqualTo(String value) {
            addCriterion("job_desc <>", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescGreaterThan(String value) {
            addCriterion("job_desc >", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescGreaterThanOrEqualTo(String value) {
            addCriterion("job_desc >=", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLessThan(String value) {
            addCriterion("job_desc <", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLessThanOrEqualTo(String value) {
            addCriterion("job_desc <=", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescLike(String value) {
            addCriterion("job_desc like", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotLike(String value) {
            addCriterion("job_desc not like", value, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescIn(List<String> values) {
            addCriterion("job_desc in", values, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotIn(List<String> values) {
            addCriterion("job_desc not in", values, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescBetween(String value1, String value2) {
            addCriterion("job_desc between", value1, value2, "jobDesc");
            return (Criteria) this;
        }

        public Criteria andJobDescNotBetween(String value1, String value2) {
            addCriterion("job_desc not between", value1, value2, "jobDesc");
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

        public Criteria andOffsetIsNull() {
            addCriterion("offset is null");
            return (Criteria) this;
        }

        public Criteria andOffsetIsNotNull() {
            addCriterion("offset is not null");
            return (Criteria) this;
        }

        public Criteria andOffsetEqualTo(Integer value) {
            addCriterion("offset =", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetNotEqualTo(Integer value) {
            addCriterion("offset <>", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetGreaterThan(Integer value) {
            addCriterion("offset >", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("offset >=", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetLessThan(Integer value) {
            addCriterion("offset <", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("offset <=", value, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetIn(List<Integer> values) {
            addCriterion("offset in", values, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetNotIn(List<Integer> values) {
            addCriterion("offset not in", values, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetBetween(Integer value1, Integer value2) {
            addCriterion("offset between", value1, value2, "offset");
            return (Criteria) this;
        }

        public Criteria andOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("offset not between", value1, value2, "offset");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNull() {
            addCriterion("job_status is null");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNotNull() {
            addCriterion("job_status is not null");
            return (Criteria) this;
        }

        public Criteria andJobStatusEqualTo(String value) {
            addCriterion("job_status =", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotEqualTo(String value) {
            addCriterion("job_status <>", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThan(String value) {
            addCriterion("job_status >", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThanOrEqualTo(String value) {
            addCriterion("job_status >=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThan(String value) {
            addCriterion("job_status <", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThanOrEqualTo(String value) {
            addCriterion("job_status <=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLike(String value) {
            addCriterion("job_status like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotLike(String value) {
            addCriterion("job_status not like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusIn(List<String> values) {
            addCriterion("job_status in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotIn(List<String> values) {
            addCriterion("job_status not in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusBetween(String value1, String value2) {
            addCriterion("job_status between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotBetween(String value1, String value2) {
            addCriterion("job_status not between", value1, value2, "jobStatus");
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
    }

    /**
     * cuckoo_job_detail表的操作类
     * 
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * cuckoo_job_detail表的操作类
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