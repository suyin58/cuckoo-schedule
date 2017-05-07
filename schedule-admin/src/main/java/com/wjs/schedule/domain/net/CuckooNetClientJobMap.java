package com.wjs.schedule.domain.net;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooNetClientJobMap implements Serializable {
    /**
     * 标准ID -- cuckoo_net_client_job_map.id
     * 
     */
    private Long id;

    /**
     * 客户端ID -- cuckoo_net_client_job_map.client_id
     * 
     */
    private Long clientId;

    /**
     * 任务注册ID -- cuckoo_net_client_job_map.regist_id
     * 
     */
    private Long registId;

    /**
     * cuckoo_net_client_job_map表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_net_client_job_map.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_net_client_job_map.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_net_client_job_map.client_id的get方法 
     * 
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * 数据字段 cuckoo_net_client_job_map.client_id的set方法
     * 
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * 数据字段 cuckoo_net_client_job_map.regist_id的get方法 
     * 
     */
    public Long getRegistId() {
        return registId;
    }

    /**
     * 数据字段 cuckoo_net_client_job_map.regist_id的set方法
     * 
     */
    public void setRegistId(Long registId) {
        this.registId = registId;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}