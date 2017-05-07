package com.wjs.schedule.vo.job;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 下级任务信息
 * @author Silver
 *
 */
public class JobNext {

	/**
	 * 当前任务id
	 */
	private Long jobId;
	
	/**
	 * 触发的下一级任务ID
	 */
	private Long nextJobId;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getNextJobId() {
		return nextJobId;
	}

	public void setNextJobId(Long nextJobId) {
		this.nextJobId = nextJobId;
	}
	
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
