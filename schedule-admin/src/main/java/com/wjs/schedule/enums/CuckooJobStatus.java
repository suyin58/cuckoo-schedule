package com.wjs.schedule.enums;

import java.util.Arrays;

/**
 * 任务状态
 * @author Silver
 *
 */
public enum CuckooJobStatus {
	

	NULL("", "全部/无"),
	PAUSE("PAUSE", "暂停"), 
	RUNNING("RUNNING", "启动"); 
	
	private final String value;
	
	private final String description;
	
	CuckooJobStatus(String value, String description) {

		this.value = value;
		this.description = description;

	}
	

	public String getValue() {
		return value;
	}



	public String getDescription() {
		return description;
	}

	public static CuckooJobStatus fromName(String input) {

		for (CuckooJobStatus item : CuckooJobStatus.values()) {
			if (item.name().equalsIgnoreCase(input))
				return item;
		}
		
		return null;
	}


	public static CuckooJobStatus[] valuesNoNull() {

		CuckooJobStatus[] result = CuckooJobStatus.values();
		for (int i = 0; i < result.length; i++) {
			if(CuckooJobStatus.NULL.equals(result[i])){
				// 提出null元素 --用最后一个元素替换，然后删除最后一个元素
				result[i]= result[result.length-1];
				//数组缩容
				result = Arrays.copyOf(result, result.length-1);
			}
		}
		return result;
	}	
	
}

