package com.wjs.schedule.domain.exec;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooJobExtend implements Serializable {
    /**
     * 任务ID -- cuckoo_job_extend.job_id
     * 
     */
    private Long jobId;

    /**
     * 邮件列表逗号分隔 -- cuckoo_job_extend.email_list
     * 
     */
    private String emailList;

    /**
     * 邮件超时时间设置(毫秒) -- cuckoo_job_extend.over_time_long
     * 
     */
    private Long overTimeLong;

    /**
     * cuckoo_job_extend表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_job_extend.job_id的get方法 
     * 
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 数据字段 cuckoo_job_extend.job_id的set方法
     * 
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 数据字段 cuckoo_job_extend.email_list的get方法 
     * 
     */
    public String getEmailList() {
        return emailList;
    }

    /**
     * 数据字段 cuckoo_job_extend.email_list的set方法
     * 
     */
    public void setEmailList(String emailList) {
        this.emailList = emailList == null ? null : emailList.trim();
    }

    /**
     * 数据字段 cuckoo_job_extend.over_time_long的get方法 
     * 
     */
    public Long getOverTimeLong() {
        return overTimeLong;
    }

    /**
     * 数据字段 cuckoo_job_extend.over_time_long的set方法
     * 
     */
    public void setOverTimeLong(Long overTimeLong) {
        this.overTimeLong = overTimeLong;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}