package com.wjs.util.dao;

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
public class PageDataList<T> implements java.io.Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5760421801476867491L;

	
	
	
	/**
	 * 当前页
	 */
	private Integer page = 1;

	/**
	 * 每页显示记录数
	 */
	private Integer pageSize = 10;

	/**
	 * 总个数
	 */
	private long total = 0;

	/**
	 * 返回的数据集
	 */
	private List<T> rows = new ArrayList<T>();
	
	
	
	

	public PageDataList() {
		super();
	}

	public PageDataList(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageDataList(Integer page, Integer pageSize, long total, List<T> rows) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
		this.rows = rows;
	}

	/**
	 * 一共有多少条
	 * 
	 * @Title: getTotal
	 * @Description:
	 * @return long
	 * @throws
	 */
	public long getTotal() {

		return total;
	}

	public void setTotal(long total) {

		this.total = total;
	}

	/**
	 * 返回数据集
	 * 
	 * @Title: getRows
	 * @Description:
	 * @return List<T>
	 * @throws
	 */
	public List<T> getRows() {

		return rows;
	}

	public void setRows(List<T> rows) {

		this.rows = rows;
	}

	public Integer getPage() {

		Integer realPages = getPageCount();
		return page > realPages ? realPages : page;
	}

	public void setPage(Integer page) {

		this.page = page;
	}

	public Integer getPageSize() {

		return pageSize;
	}

	public void setPageSize(Integer pageSize) {

		this.pageSize = pageSize;
	}

	public Integer getPageCount() {

		long realPages = total / pageSize;
		long remain = total % pageSize;
		realPages = remain > 0 ? (realPages + 1) : realPages;
		return (int)realPages;
	}

	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}


}
