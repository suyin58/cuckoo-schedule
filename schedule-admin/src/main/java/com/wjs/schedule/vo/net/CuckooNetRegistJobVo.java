package com.wjs.schedule.vo.net;

import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooNetRegistJobVo {
    /**
     * 标准ID -- cuckoo_net_regist_job.id
     * 
     */
    private Long id;

    /**
     * 作业执行应用名 -- cuckoo_net_regist_job.job_class_application
     * 
     */
    private String jobClassApplication;

    /**
     * 任务名称 -- cuckoo_net_regist_job.job_name
     * 
     */
    private String jobName;

    /**
     * 实现类名称 -- cuckoo_net_regist_job.bean_name
     * 
     */
    private String beanName;

    /**
     * 方法名称 -- cuckoo_net_regist_job.method_name
     * 
     */
    private String methodName;

    /**
     * 创建时间 -- cuckoo_net_regist_job.create_date
     * 
     */
    private Long createDate;

    /**
     * 修改时间 -- cuckoo_net_regist_job.modify_date
     * 
     */
    private Long modifyDate;
    
    private Set<String> clients;
    
    private Set<String> servers;

    /**
     * cuckoo_net_regist_job表的操作属性:serialVersionUID
     * 
     */
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_net_regist_job.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.job_class_application的get方法 
     * 
     */
    public String getJobClassApplication() {
        return jobClassApplication;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.job_class_application的set方法
     * 
     */
    public void setJobClassApplication(String jobClassApplication) {
        this.jobClassApplication = jobClassApplication == null ? null : jobClassApplication.trim();
    }

    /**
     * 数据字段 cuckoo_net_regist_job.job_name的get方法 
     * 
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.job_name的set方法
     * 
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 数据字段 cuckoo_net_regist_job.bean_name的get方法 
     * 
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.bean_name的set方法
     * 
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    /**
     * 数据字段 cuckoo_net_regist_job.method_name的get方法 
     * 
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.method_name的set方法
     * 
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 数据字段 cuckoo_net_regist_job.create_date的get方法 
     * 
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.create_date的set方法
     * 
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.modify_date的get方法 
     * 
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * 数据字段 cuckoo_net_regist_job.modify_date的set方法
     * 
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    
    

    public Set<String> getClients() {
		return clients;
	}

	public void setClients(Set<String> clients) {
		this.clients = clients;
	}

	public Set<String> getServers() {
		return servers;
	}

	public void setServers(Set<String> servers) {
		this.servers = servers;
	}

	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
