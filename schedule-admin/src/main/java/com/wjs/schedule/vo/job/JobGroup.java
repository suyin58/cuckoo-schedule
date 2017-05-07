package com.wjs.schedule.vo.job;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 任务分组信息
 * @author Silver
 *
 */
public class JobGroup {
	
	/**
	 * 分组id
	 */
	private Long id;
	
	/**
	 * 分组名称
	 */
	private String groupName;
	
	/**
	 * 分组描述
	 */
	private String groupDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
	
	
	
}
