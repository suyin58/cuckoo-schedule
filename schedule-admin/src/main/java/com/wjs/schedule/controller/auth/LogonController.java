package com.wjs.schedule.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.constant.CuckooWebConstant;
import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.domain.auth.CuckooAuthUser;
import com.wjs.schedule.enums.CuckooAdminPages;
import com.wjs.schedule.enums.CuckooUserAuthType;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.service.auth.CuckooAuthService;
import com.wjs.schedule.service.job.CuckooGroupService;
import com.wjs.schedule.util.PasswordUtil;
import com.wjs.schedule.vo.auth.CuckooAuthUserVo;
import com.wjs.schedule.vo.auth.CuckooLogonInfo;
import com.wjs.util.bean.PropertyUtil;

@Controller
@RequestMapping("/logon")
public class LogonController extends BaseController{
	
	@Autowired
	CuckooAuthService cuckooAuthService;
	
	@Autowired
	CuckooGroupService cuckooGroupService;
	
	@RequestMapping("/index")
	public Object logon(HttpServletRequest request,String redirectUrl){

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		System.out.println(requestUri +" _ " + contextPath);

		return CuckooAdminPages.LOGIN.getValue();
	}
	
	

	@RequestMapping("/regist")
	@ResponseBody
	public Object regist(HttpServletRequest request,CuckooAuthUserVo user){
		
		if(StringUtils.isEmpty(user.getUserPwd())){
			throw new BaseException("password should not be null");
		}
		
		if(null == user.getId()){
			// 用户新增
			// 用户名是否存在
			cuckooAuthService.isUsernameExist(user.getUserName());
			
			// 外部注册的默认为普通用户
			CuckooAuthUser cuckooAuthUser = new CuckooAuthUser();
			PropertyUtil.copyProperties(cuckooAuthUser, user);
			cuckooAuthUser.setUserAuthType(CuckooUserAuthType.GUEST.getValue());
			cuckooAuthUser.setUserPwd(PasswordUtil.encrypt(user.getUserPwd()));
			cuckooAuthService.addUser(cuckooAuthUser);
			
		}else{
			//用户修改
			CuckooAuthUser cuckooAuthUser = cuckooAuthService.getUserInfoById(user.getId());
			cuckooAuthUser.setEmail(user.getEmail());
			cuckooAuthUser.setOrgName(user.getOrgName());
			cuckooAuthUser.setPhone(user.getPhone());
			cuckooAuthUser.setUserAuthType(user.getUserAuthType());
			// cuckooAuthUser.setUserName(user.getUserName());
			if(StringUtils.isNotEmpty(user.getUserPwd())){

				cuckooAuthUser.setUserPwd(PasswordUtil.encrypt(user.getUserPwd()));
			}
			cuckooAuthService.update(cuckooAuthUser);
		}
		
		return success(CuckooAdminPages.INDEX.getValue());
	}
	
	@RequestMapping("/in")
	@ResponseBody
	public Object login(HttpServletRequest request,String user, String pwd){
		
		CuckooLogonInfo logonInfo = null;

		logonInfo = cuckooAuthService.getLogonInfo(user, pwd);
		
		
		// 查询数据库
		if(null == logonInfo){
			
			throw new BaseException("unknow userName:{},password:{},please try using [guest,]", user, pwd);
		}
		
		request.getSession().setAttribute(CuckooWebConstant.ADMIN_WEB_SESSION_USER_KEY, logonInfo);
		 
		return success(CuckooAdminPages.INDEX.getValue());
	}
	
	
	@RequestMapping("/out")
	@ResponseBody
	public Object logout(HttpServletRequest request,String redirectUrl){
		
		
		request.getSession().invalidate();
		

		request.setAttribute("redirectUrl", redirectUrl);
		if(null != redirectUrl){
		
			return success(redirectUrl);
		}
		return success(CuckooAdminPages.INDEX.getValue());
	}
	
}
