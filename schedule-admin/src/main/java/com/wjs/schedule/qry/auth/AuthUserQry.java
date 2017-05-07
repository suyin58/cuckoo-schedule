package com.wjs.schedule.qry.auth;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.qry.QryBase;

public class AuthUserQry extends QryBase{
	
	private String userAuthType;

	public String getUserAuthType() {
		return userAuthType;
	}

	public void setUserAuthType(String userAuthType) {
		this.userAuthType = userAuthType;
	}
	
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
