package com.wjs.schedule.vo.auth;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooGroupAuthVo {
     
     private Long id;
     private Long userId;
     private Long groupId;
     private String userName;
     private String userAuthType;
     private String readable;
     private String writable;
     private String grantable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAuthType() {
		return userAuthType;
	}
	public void setUserAuthType(String userAuthType) {
		this.userAuthType = userAuthType;
	}
	public String getWritable() {
		return writable;
	}
	public void setWritable(String writable) {
		this.writable = writable;
	}
	public String getReadable() {
		return readable;
	}
	public void setReadable(String readable) {
		this.readable = readable;
	}
	public String getGrantable() {
		return grantable;
	}
	public void setGrantable(String grantable) {
		this.grantable = grantable;
	}
     
     @Override
    public String toString() {
    	 
    	return ReflectionToStringBuilder.toString(this);
    }
     
}
