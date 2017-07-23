package com.wjs.schedule.enums;

public enum CuckooUserAuthType {
	
	
	ADMIN("ADMIN", "管理员")/*管理员拥有所有查看/修改/赋权权限*/, 
	GUEST("GUEST", "游客")/*游客拥有所有查看权限*/,
	NORMAL("NORMAL", "普通用户")/*普通用户按照jobgroup的配置拥有权限*/; 
	
	private final String value;
	
	private final String description;
	
	CuckooUserAuthType(String value, String description) {

		this.value = value;
		this.description = description;

	}
	

	public String getValue() {
		return value;
	}



	public String getDescription() {
		return description;
	}

	public static CuckooUserAuthType fromName(String input) {

		for (CuckooUserAuthType item : CuckooUserAuthType.values()) {
			if (item.name().equalsIgnoreCase(input))
				return item;
		}
		
		return null;
	}	

}

