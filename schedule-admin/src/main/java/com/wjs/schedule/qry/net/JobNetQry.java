package com.wjs.schedule.qry.net;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.qry.QryBase;

public class JobNetQry extends QryBase{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jobClassApplication;
	
	private String jobName;
	
	


	public String getJobClassApplication() {
		return jobClassApplication;
	}

	public void setJobClassApplication(String jobClassApplication) {
		this.jobClassApplication = jobClassApplication;
	}
	
	
	
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
