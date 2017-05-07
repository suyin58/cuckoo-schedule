package com.wjs.schedule.domain.exec;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooJobDependency implements Serializable {
    /**
     * 标准ID -- cuckoo_job_dependency.id
     * 
     */
    private Long id;

    /**
     * 任务ID -- cuckoo_job_dependency.job_id
     * 
     */
    private Long jobId;

    /**
     * 依赖任务ID -- cuckoo_job_dependency.dependency_job_id
     * 
     */
    private Long dependencyJobId;

    /**
     * cuckoo_job_dependency表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_job_dependency.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_job_dependency.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_job_dependency.job_id的get方法 
     * 
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 数据字段 cuckoo_job_dependency.job_id的set方法
     * 
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 数据字段 cuckoo_job_dependency.dependency_job_id的get方法 
     * 
     */
    public Long getDependencyJobId() {
        return dependencyJobId;
    }

    /**
     * 数据字段 cuckoo_job_dependency.dependency_job_id的set方法
     * 
     */
    public void setDependencyJobId(Long dependencyJobId) {
        this.dependencyJobId = dependencyJobId;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}