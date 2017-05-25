package com.wjs.schedule.web.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wjs.schedule.constant.CuckooWebConstant;
import com.wjs.schedule.enums.CuckooAdminPages;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.service.auth.CuckooAuthService;
import com.wjs.schedule.vo.auth.CuckooLogonInfo;

public class LogonInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 不需要拦截的资源
	 */
	private List<String> excludeUrls;
	
	@Autowired
	CuckooAuthService cuckooAuthService;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		super.preHandle(request, response, handler);

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String uri = requestUri.substring(contextPath.length());
		// 不需要登录即可访问的
		for (String url : excludeUrls) {
			if (isExcludeUrl(request.getContextPath(), uri, url)) {
				return true;
			}
		}


		Object logonInfo = request.getSession().getAttribute(CuckooWebConstant.ADMIN_WEB_SESSION_USER_KEY);
		
		// 如果没有登录或登录超时
		if (null == logonInfo) {
			String requestType = request.getHeader("X-Requested-With");
			// 判断用户请求方式是否为异步请求
			if (StringUtils.isNotBlank(requestType) && requestType.equals("XMLHttpRequest")) {
				throw new BaseException("登录超时，请先登录");
			} else {
				// 未登录时记录上一次操作地址
				String servletPath = request.getServletPath();
				String queryString = request.getQueryString();
//				System.out.println(request.getScheme());
//				System.out.println(request.getServerName());
//				System.out.println(request.getServerPort());
//				System.out.println(request.getContextPath());
				String redirectURL = servletPath;
				if (StringUtils.isNotBlank(queryString)) {
					redirectURL = request.getContextPath() + servletPath + "?" + StringUtils.trimToEmpty(queryString);
				}
				redirectURL = URLEncoder.encode(redirectURL, CuckooWebConstant.ADMIN_WEB_ENCODING);
				String allUrl = request.getContextPath() + CuckooAdminPages.LOGIN.getValue() + "?redirectURL="+ redirectURL;
				// 转到登录页
				response.sendRedirect(allUrl);
			}
			return false;
		} else{
			// 设置threadLocal
			CuckooLogonInfo cuckooLogonInfo = (CuckooLogonInfo)logonInfo;
			cuckooAuthService.setLogonInfo(cuckooLogonInfo);
//			System.out.println(cuckooLogonInfo);
			request.setAttribute("logonInfo", cuckooLogonInfo);
		}

		return true;
	}
	
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
		cuckooAuthService.clearLogon();
	}


	private boolean isExcludeUrl(String ContextPath, String requestUri, String url) {
//		if (StringUtils.isNotEmpty(ContextPath) && requestUri.length() > ContextPath.length()) {
//			requestUri = requestUri.substring(ContextPath.length(), requestUri.length());
//		}
		if (requestUri.equals(url)) {
			return true;
		}
		if (url.endsWith("*") && requestUri.startsWith(url.substring(0, url.length() - 2))) {
			return true;
		}
		return false;
	}
}
