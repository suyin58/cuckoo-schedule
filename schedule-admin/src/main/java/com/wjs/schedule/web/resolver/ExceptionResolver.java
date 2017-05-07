package com.wjs.schedule.web.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wjs.schedule.enums.CuckooAdminPages;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.web.util.JsonResult;
import com.wjs.schedule.web.util.JsonResult.Status;

/**
 * 异常处理类
 * 
 * @ClassName: ExceptionResolver
 * @Description: 处理全局异常
 * @author wzh
 * @date 2015年1月25日 下午4:48:49
 *
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);
	private static final Gson gson = new GsonBuilder().create();

	@Override
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		// 把异常信息记入日志
		if (null != ex) {
			LOGGER.error("ERROR_MARK: {},message", ex.getClass(), ex.getMessage(), ex);
		}


		String message = "";
		if(ex instanceof BaseException){
			message = ex.getMessage(); // 自定义异常特殊处理
		}else{
			message = "系统异常:" + ex.getMessage();
		}
		String requestType = request.getHeader("X-Requested-With");
		//判断用户请求方式是否为ajax
		if (StringUtils.isNotBlank(requestType) && requestType.equals("XMLHttpRequest")) {
			// Json返回数据
			JsonResult<String> json = new JsonResult<String>(Status.ERROR, message);
			// 打印输出json字符串
			printJson(response, gson.toJson(json));
			return null;
		} else {
			ModelAndView modelAndView = new ModelAndView(CuckooAdminPages.ERROR.getValue());
			modelAndView.addObject("message", StringUtils.trimToNull(message));
			return modelAndView;
		}

	}


	/**
	 * 
	 * @Title: printJson
	 * @Description: 打印输出json字符串
	 * @param response
	 * @param json
	 * 输出文字
	 * @return void 返回类型
	 * @throws
	 */
	private void printJson(final HttpServletResponse response, final String json) {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(json);

		} catch (IOException ex) {
			LOGGER.error(json, ex);
		} finally {
			if (out != null)
				out.flush();
			if (out != null)
				out.close();
		}
	}

	@Override
	public int getOrder() {

		return 0;
	}

}
