package com.wjs.schedule.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.domain.auth.CuckooAuthUser;
import com.wjs.schedule.enums.CuckooAdminPages;
import com.wjs.schedule.enums.CuckooUserAuthType;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.qry.auth.AuthUserQry;
import com.wjs.schedule.service.auth.CuckooAuthService;
import com.wjs.schedule.util.PasswordUtil;
import com.wjs.schedule.vo.auth.CuckooAuthUserVo;
import com.wjs.schedule.vo.auth.CuckooLogonInfo;
import com.wjs.util.bean.PropertyUtil;
import com.wjs.util.dao.PageDataList;

@Controller
@RequestMapping("/manage")
public class ManageController extends BaseController{

	
	@Autowired
	CuckooAuthService cuckooAuthService;
	
	@RequestMapping
	public String index0(HttpServletRequest request) {

		return index(request);
	}

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {

		


		request.setAttribute("userTypes", CuckooUserAuthType.values());
		if(cuckooAuthService.getLogonInfo().getCuckooUserAuthType().getValue().equals(CuckooUserAuthType.ADMIN.getValue())){
			// 管理员跳转管理页面
			return "manage/manage.index";
		}else{
			// 跳转个人页面

			return "redirect:manage/userdetail?id=" + cuckooAuthService.getLogonInfo().getId()+"&from=mine";
		}
		

	}
	
	@RequestMapping(value = "/userdetail")
	public String userdetail(HttpServletRequest request,Long id,String from) {
		
		if(null != id){
			
			CuckooAuthUser user = cuckooAuthService.getUserInfoById(id);
			if(null == user){
				throw new BaseException("can not get user by id:{}", id);
			}
			
			CuckooLogonInfo logonInfo = cuckooAuthService.getLogonInfo();
			if(!CuckooUserAuthType.ADMIN.getValue().equals(logonInfo.getCuckooUserAuthType().getValue())){
				// 非管理员，只能查看自己的信息
				if(!logonInfo.getId().equals(user.getId())){
					throw new BaseException("user have no right to see other's infomation");
				}
			}
			request.setAttribute("userInfo", user);
		}
		request.setAttribute("userTypes", CuckooUserAuthType.values());

		return "manage/manage.userdetail";

	}
	
	
	@RequestMapping("/userList")
	@ResponseBody
	public Object userList(HttpServletRequest request,AuthUserQry qry){
		
		PageDataList<CuckooAuthUser> userPage = cuckooAuthService.pageAuthUser(qry);
		return dataTable(userPage);
	}
	
	
	
}
