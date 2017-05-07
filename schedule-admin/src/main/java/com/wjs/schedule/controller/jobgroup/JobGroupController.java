package com.wjs.schedule.controller.jobgroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.dao.exec.CuckooJobGroupMapper;
import com.wjs.schedule.domain.exec.CuckooJobGroup;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.qry.job.GroupAuthQry;
import com.wjs.schedule.service.auth.CuckooAuthService;
import com.wjs.schedule.service.job.CuckooGroupService;
import com.wjs.schedule.vo.auth.CuckooGroupAuthVo;
import com.wjs.schedule.vo.job.JobGroup;
import com.wjs.util.bean.PropertyUtil;
import com.wjs.util.dao.PageDataList;

@Controller
@RequestMapping("/jobgroup")
public class JobGroupController  extends BaseController{

	
	@Autowired
	CuckooGroupService cuckooGroupService;
	
	@Autowired
	CuckooJobGroupMapper cuckooJobGroupMapper;
	
	@Autowired
	CuckooAuthService cuckooAuthService;
	
	@RequestMapping
	public String index0(HttpServletRequest request) {
		
		return index(request);
	}
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {
		
		List<CuckooJobGroup> jobGroups = cuckooGroupService.listAllGroup();
		request.setAttribute("jobGroups", jobGroups);
		
		return "jobgroup/jobgroup.index";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(HttpServletRequest request, JobGroup jobGroup){
		
		CuckooJobGroup cuckooJobGroup = new CuckooJobGroup();
		PropertyUtil.copyProperties(cuckooJobGroup, jobGroup);
		
		if(StringUtils.isEmpty(jobGroup.getGroupName())){
			
			throw new BaseException("group name can not be null");
		}
		
		if(jobGroup.getId() != null){
			
			// 更新
			cuckooGroupService.updateByPk(cuckooJobGroup);
		}else{
			// 新增
			cuckooGroupService.addGroup(cuckooJobGroup);
		}
		
		return success();
	}
	

	@RequestMapping(value = "/remove")
	@ResponseBody
	public Object remove(HttpServletRequest request, Long id){
		
		if(null == id){
			
			throw new BaseException("id can not be null");
		}
		
		cuckooGroupService.deleteById(id);
		
		return success();
	}
	

	@RequestMapping(value = "/groupauthlist")
	@ResponseBody
	public Object authlist(HttpServletRequest request, GroupAuthQry qry){
		
		if(null == qry.getGroupId()){
			return dataTable(null);
		}
		
		PageDataList<CuckooGroupAuthVo> pageData = cuckooAuthService.pageGroupAuth(qry);
		
		
		return dataTable(pageData);
	}
	
	@RequestMapping(value = "/changeAuth")
	@ResponseBody
	public Object changeAuth(HttpServletRequest request, String type, Long authId, Long userId, Long groupId){

		if(StringUtils.isEmpty(type)){
			throw new BaseException("param error,type can not be null");
		}
		if(null != authId &&(null == userId ||  null == groupId)){
			throw new BaseException("param error,authId:{},userId:{},groupId:{}", authId , userId , groupId);
		}
		
		cuckooAuthService.changeAuth(type, authId, userId, groupId);
		
		
		return success();
	}
	
	
}
