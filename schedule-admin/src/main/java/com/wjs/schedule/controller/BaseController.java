package com.wjs.schedule.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.wjs.schedule.web.util.JqueryDataTable;
import com.wjs.schedule.web.util.JsonResult;
import com.wjs.util.dao.PageDataList;

/**
 * 基础控制器
 * 
 * 其他控制器继承此控制器获得日期字段类型转换和防止XSS攻击的功能
 * 
 * @author Moon
 * 
 */
@Controller
public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {

		/**
		 * 自动转换日期类型的字段格式
		 */
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//						new SimpleDateFormat("yyyy-MM-dd"), true));

		/**
		 * 防止XSS攻击
		 */
//		binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
	}
	

	/**
	 * http请求成功时调用
	 * 
	 * @return
	 * 
	 * @author chenchunhui
	 */
	protected <T> JsonResult<T> success() {
		return this.success("操作成功", null);
	}

	/**
	 * http请求成功时调用
	 * 
	 * @param data
	 *        返回给前台的数据
	 * @return 返回给前台的标准json对象
	 */
	protected <T> JsonResult<T> success(T data) {
		return this.success("操作成功", data);
	}

	/**
	 * http请求成功时调用
	 * 
	 * @param msg
	 *        信息说明
	 * @param data
	 *        返回给前端的数据
	 * @param <T>
	 * @return 返回给前台的标准json对象
	 * 
	 * @author chenchunhui
	 */
	protected <T> JsonResult<T> success(String msg, T data) {
		JsonResult<T> result = new JsonResult<T>(JsonResult.Status.SUCCESS, msg, data);
		if (LOGGER.isDebugEnabled()) {
			String logString = result.toString();
			if (logString.length() > 1024) {
				logString = logString.substring(0, 1024);
			}
			LOGGER.debug(logString);
		}
		return result;
	}

	/**
	 * http请求失败时调用
	 * 
	 * @return 返回给前台的标准json对象
	 * 
	 * @author chenchunhui
	 */
	protected <T> JsonResult<T> error() {
		return this.error("系统错误");
	}

	/**
	 * http请求失败时调用
	 * 
	 * @param msg
	 *        信息说明
	 * @return 返回给前台的标准json对象
	 * 
	 * @author chenchunhui
	 */
	protected <T> JsonResult<T> error(String msg) {
		JsonResult<T> result = new JsonResult<T>(JsonResult.Status.ERROR, msg);
		if (LOGGER.isInfoEnabled()) {
			String logString = result.toString();
			if (logString.length() > 1024) {
				logString = logString.substring(0, 1024);
			}
			LOGGER.info(logString);
		}
		return result;
	}
	
	public String redict(String page){
		
		return "redirect:" + page;
	}
	 
	/**
	 * parse PageDataList to JqueryDataTable
	 * @param page
	 * @return
	 */
	public <T> JqueryDataTable<T>  dataTable(PageDataList<T> page) {
		JqueryDataTable<T> t = new JqueryDataTable<>();
		if(null != page){

			t.setData(page.getRows());
			t.setRecordsFiltered(page.getTotal());
			t.setRecordsTotal(page.getTotal());
		}else{
		
	
			t.setData(new ArrayList<T>());
			t.setRecordsFiltered(0);
			t.setRecordsTotal(0);
		}
		return t;
	}

}
