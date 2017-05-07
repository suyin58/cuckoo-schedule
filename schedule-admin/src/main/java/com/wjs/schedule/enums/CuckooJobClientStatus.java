package com.wjs.schedule.enums;

/**
 * 任务状态
 * @author Silver
 *
 */
public enum CuckooJobClientStatus {

	 NULL("", "全部/无"),
	 RUNNING("RUNNING", "运行中"),
	 OFFLINE("OFFLINE", "断线"); 
	
	private final String value;
	
	private final String description;
	
	CuckooJobClientStatus(String value, String description) {

		this.value = value;
		this.description = description;

	}
	

	public String getValue() {
		return value;
	}



	public String getDescription() {
		return description;
	}

	public static CuckooJobClientStatus fromName(String input) {

		for (CuckooJobClientStatus item : CuckooJobClientStatus.values()) {
			if (item.name().equalsIgnoreCase(input))
				return item;
		}
		
		return null;
	}	

}

