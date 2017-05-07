package com.wjs.schedule.vo.job;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 依赖任务信息
 * @author Silver
 *
 */
public class JobDependency {
	
	/**
	 * 任务ID
	 */
	private Long jobId;
	
	/**
	 * 依赖的任务ID
	 */
	private Long dependencyId;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getDependencyId() {
		return dependencyId;
	}

	public void setDependencyId(Long dependencyId) {
		this.dependencyId = dependencyId;
	}
	
	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}
	
}
