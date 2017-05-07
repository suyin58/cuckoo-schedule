package com.wjs.schedule.domain.exec;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooJobGroup implements Serializable {
    /**
     * 标准ID -- cuckoo_job_group.id
     * 
     */
    private Long id;

    /**
     * 分组名称 -- cuckoo_job_group.group_name
     * 
     */
    private String groupName;

    /**
     * 分组描述 -- cuckoo_job_group.group_desc
     * 
     */
    private String groupDesc;

    /**
     * cuckoo_job_group表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_job_group.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_job_group.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_job_group.group_name的get方法 
     * 
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 数据字段 cuckoo_job_group.group_name的set方法
     * 
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 数据字段 cuckoo_job_group.group_desc的get方法 
     * 
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * 数据字段 cuckoo_job_group.group_desc的set方法
     * 
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc == null ? null : groupDesc.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}