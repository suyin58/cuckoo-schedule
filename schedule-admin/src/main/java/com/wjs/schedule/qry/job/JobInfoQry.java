package com.wjs.schedule.qry.job;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.qry.QryBase;

public class JobInfoQry  extends QryBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long groupId;
	
	private String jobClassApplication ;
	private Long jobId ;
	private String jobStatus ;
	private String jobExecStatus ;


	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public String getJobClassApplication() {
		return jobClassApplication;
	}


	public void setJobClassApplication(String jobClassApplication) {
		this.jobClassApplication = jobClassApplication;
	}


	public Long getJobId() {
		return jobId;
	}


	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}


	public String getJobStatus() {
		return jobStatus;
	}


	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}


	public String getJobExecStatus() {
		return jobExecStatus;
	}


	public void setJobExecStatus(String jobExecStatus) {
		this.jobExecStatus = jobExecStatus;
	}


	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}
}
