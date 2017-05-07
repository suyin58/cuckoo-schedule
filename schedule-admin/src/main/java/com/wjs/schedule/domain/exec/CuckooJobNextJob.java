package com.wjs.schedule.domain.exec;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooJobNextJob implements Serializable {
    /**
     * 标准ID -- cuckoo_job_next_job.id
     * 
     */
    private Long id;

    /**
     * 任务ID -- cuckoo_job_next_job.job_id
     * 
     */
    private Long jobId;

    /**
     * 下级任务ID -- cuckoo_job_next_job.next_job_id
     * 
     */
    private Long nextJobId;

    /**
     * cuckoo_job_next_job表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_job_next_job.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_job_next_job.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_job_next_job.job_id的get方法 
     * 
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 数据字段 cuckoo_job_next_job.job_id的set方法
     * 
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 数据字段 cuckoo_job_next_job.next_job_id的get方法 
     * 
     */
    public Long getNextJobId() {
        return nextJobId;
    }

    /**
     * 数据字段 cuckoo_job_next_job.next_job_id的set方法
     * 
     */
    public void setNextJobId(Long nextJobId) {
        this.nextJobId = nextJobId;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}