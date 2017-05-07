package com.wjs.schedule.domain.auth;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooAuthJobgrp implements Serializable {
    /**
     * 标准ID -- cuckoo_auth_jobgrp.id
     * 
     */
    private Long id;

    /**
     * 分组ID -- cuckoo_auth_jobgrp.group_id
     * 
     */
    private Long groupId;

    /**
     * 用户ID -- cuckoo_auth_jobgrp.user_id
     * 
     */
    private Long userId;

    /**
     * 可写 -- cuckoo_auth_jobgrp.writable
     * 
     */
    private String writable;

    /**
     * 可读 -- cuckoo_auth_jobgrp.readable
     * 
     */
    private String readable;

    /**
     * 可分配 -- cuckoo_auth_jobgrp.grantable
     * 
     */
    private String grantable;

    /**
     * cuckoo_auth_jobgrp表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_auth_jobgrp.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.group_id的get方法 
     * 
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.group_id的set方法
     * 
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.user_id的get方法 
     * 
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.user_id的set方法
     * 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.writable的get方法 
     * 
     */
    public String getWritable() {
        return writable;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.writable的set方法
     * 
     */
    public void setWritable(String writable) {
        this.writable = writable == null ? null : writable.trim();
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.readable的get方法 
     * 
     */
    public String getReadable() {
        return readable;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.readable的set方法
     * 
     */
    public void setReadable(String readable) {
        this.readable = readable == null ? null : readable.trim();
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.grantable的get方法 
     * 
     */
    public String getGrantable() {
        return grantable;
    }

    /**
     * 数据字段 cuckoo_auth_jobgrp.grantable的set方法
     * 
     */
    public void setGrantable(String grantable) {
        this.grantable = grantable == null ? null : grantable.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}