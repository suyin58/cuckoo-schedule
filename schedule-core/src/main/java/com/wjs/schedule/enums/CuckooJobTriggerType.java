package com.wjs.schedule.enums;

import java.util.Arrays;

public enum CuckooJobTriggerType {
	
 

	NULL("", "全部/无"),
	CRON("CRON", "Cron定时触发")/*任务由Cron触发*/, 
	JOB("JOB", "上级任务触发")/*任务由父任务触发*/,
	NONE("NONE", "外部调用触发")/*任务由外部调用触发*/; 
	
	private final String value;
	
	private final String description;
	
	CuckooJobTriggerType(String value, String description) {

		this.value = value;
		this.description = description;
	}
	

	public String getValue() {
		return value;
	}



	public String getDescription() {
		return description;
	}

	public static CuckooJobTriggerType fromName(String input) {

		for (CuckooJobTriggerType item : CuckooJobTriggerType.values()) {
			if (item.name().equalsIgnoreCase(input))
				return item;
		}
		
		return null;
	}	
	public static CuckooJobTriggerType[] valuesNoNull() {

		CuckooJobTriggerType[] result = CuckooJobTriggerType.values();
		for (int i = 0; i < result.length; i++) {
			if(CuckooJobTriggerType.NULL.equals(result[i])){
				// 提出null元素 --用最后一个元素替换，然后删除最后一个元素
				result[i]= result[result.length-1];
				//数组缩容
				result = Arrays.copyOf(result, result.length-1);
			}
		}
		return result;
	}	
}

