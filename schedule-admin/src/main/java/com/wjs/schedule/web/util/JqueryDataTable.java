package com.wjs.schedule.web.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 数据分页信息
 * 
 * @ClassName: PageDataList
 * @Description:
 * @param <T>
 * @param
 */
public class JqueryDataTable<T> implements java.io.Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5760421801476867491L;


	/**
	 * 总个数
	 */
	private long recordsTotal = 0;
	/**
	 * 总个数
	 */
	private long recordsFiltered = 0;

	/**
	 * 返回的数据集
	 */
	private List<T> data = new ArrayList<T>();
	
	
	
	

	public JqueryDataTable() {
		
		super();
	}

	

	public long getRecordsTotal() {
		return recordsTotal;
	}



	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}



	public long getRecordsFiltered() {
		return recordsFiltered;
	}



	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}



	public List<T> getData() {
		return data;
	}



	public void setData(List<T> data) {
		this.data = data;
	}



	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}


}
