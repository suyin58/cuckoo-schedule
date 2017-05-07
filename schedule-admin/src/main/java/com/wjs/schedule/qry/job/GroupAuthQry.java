package com.wjs.schedule.qry.job;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.qry.QryBase;

public class GroupAuthQry  extends QryBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long groupId;
	


	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}




	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}
}
