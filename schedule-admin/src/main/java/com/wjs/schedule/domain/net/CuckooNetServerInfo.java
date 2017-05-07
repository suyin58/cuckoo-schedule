package com.wjs.schedule.domain.net;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooNetServerInfo implements Serializable {
    /**
     * 标准ID -- cuckoo_net_server_info.id
     * 
     */
    private Long id;

    /**
     * IP地址 -- cuckoo_net_server_info.ip
     * 
     */
    private String ip;

    /**
     * 端口号 -- cuckoo_net_server_info.port
     * 
     */
    private Integer port;

    /**
     * 修改时间 -- cuckoo_net_server_info.modify_date
     * 
     */
    private Long modifyDate;

    /**
     * cuckoo_net_server_info表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_net_server_info.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_net_server_info.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_net_server_info.ip的get方法 
     * 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 数据字段 cuckoo_net_server_info.ip的set方法
     * 
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 数据字段 cuckoo_net_server_info.port的get方法 
     * 
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 数据字段 cuckoo_net_server_info.port的set方法
     * 
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 数据字段 cuckoo_net_server_info.modify_date的get方法 
     * 
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * 数据字段 cuckoo_net_server_info.modify_date的set方法
     * 
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}