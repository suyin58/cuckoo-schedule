package com.wjs.schedule.domain.net;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooNetServerJobMap implements Serializable {
    /**
     * 标准ID -- cuckoo_net_server_job_map.id
     * 
     */
    private Long id;

    /**
     * 服务器ID -- cuckoo_net_server_job_map.server_id
     * 
     */
    private Long serverId;

    /**
     * 任务注册ID -- cuckoo_net_server_job_map.regist_id
     * 
     */
    private Long registId;

    /**
     * cuckoo_net_server_job_map表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_net_server_job_map.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_net_server_job_map.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_net_server_job_map.server_id的get方法 
     * 
     */
    public Long getServerId() {
        return serverId;
    }

    /**
     * 数据字段 cuckoo_net_server_job_map.server_id的set方法
     * 
     */
    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    /**
     * 数据字段 cuckoo_net_server_job_map.regist_id的get方法 
     * 
     */
    public Long getRegistId() {
        return registId;
    }

    /**
     * 数据字段 cuckoo_net_server_job_map.regist_id的set方法
     * 
     */
    public void setRegistId(Long registId) {
        this.registId = registId;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}