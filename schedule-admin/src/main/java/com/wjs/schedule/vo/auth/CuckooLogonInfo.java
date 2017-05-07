package com.wjs.schedule.vo.auth;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.enums.CuckooUserAuthType;

public class CuckooLogonInfo {
	
    private Long id;

    private String phone;

    private String email;
    
    private String orgName;
	
	private String userName;
	private CuckooUserAuthType  cuckooUserAuthType;
	private List<Long> readableGroupIds;
	private List<Long> writableGroupIds;
	private List<Long> grantableGroupIds;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CuckooUserAuthType getCuckooUserAuthType() {
		return cuckooUserAuthType;
	}
	public void setCuckooUserAuthType(CuckooUserAuthType cuckooUserAuthType) {
		this.cuckooUserAuthType = cuckooUserAuthType;
	}
	public List<Long> getReadableGroupIds() {
		return readableGroupIds;
	}
	public void setReadableGroupIds(List<Long> readableGroupIds) {
		this.readableGroupIds = readableGroupIds;
	}
	public List<Long> getWritableGroupIds() {
		return writableGroupIds;
	}
	public void setWritableGroupIds(List<Long> writableGroupIds) {
		this.writableGroupIds = writableGroupIds;
	}
	public List<Long> getGrantableGroupIds() {
		return grantableGroupIds;
	}
	public void setGrantableGroupIds(List<Long> grantableGroupIds) {
		this.grantableGroupIds = grantableGroupIds;
	}
	
	
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}
}
