package com.wjs.schedule.qry;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class QryBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer start;
	private Integer limit;
	
	/**
	 * 公共分组权限
	 */
	private List<Long> groupIds;
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
	
	public List<Long> getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(List<Long> groupIds) {
		this.groupIds = groupIds;
	}
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
