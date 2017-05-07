package com.wjs.schedule.enums;

import java.util.Arrays;

/**
 * 任务执行状态
 * @author Silver
 *
 */
public enum CuckooJobExecStatus {


	NULL("", "全部/无"),
	PENDING("PENDING", "等待执行"), 
	RUNNING("RUNNING", "正在执行"), 
	FAILED("FAILED", "执行失败"),
	SUCCED("SUCCED", "执行成功"),
	BREAK("BREAK", "断线"); 
	
	private final String value;
	
	private final String description;
	
	CuckooJobExecStatus(String value, String description) {

		this.value = value;
		this.description = description;

	}
	

	public String getValue() {
		return value;
	}



	public String getDescription() {
		return description;
	}

	public static CuckooJobExecStatus fromName(String input) {

		for (CuckooJobExecStatus item : CuckooJobExecStatus.values()) {
			if (item.name().equalsIgnoreCase(input))
				return item;
		}
		
		return null;
	}	
	
	
	public static CuckooJobExecStatus[] valuesNoNull() {

		CuckooJobExecStatus[] result = CuckooJobExecStatus.values();
		for (int i = 0; i < result.length; i++) {
			if(CuckooJobExecStatus.NULL.equals(result[i])){
				// 提出null元素 --用最后一个元素替换，然后删除最后一个元素
				result[i]= result[result.length-1];
				//数组缩容
				result = Arrays.copyOf(result, result.length-1);
			}
		}
		return result;
	}	
	

}

