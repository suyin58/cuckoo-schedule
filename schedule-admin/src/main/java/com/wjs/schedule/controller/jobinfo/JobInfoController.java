package com.wjs.schedule.controller.jobinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.dao.exec.CuckooJobExtendMapper;
import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExtend;
import com.wjs.schedule.domain.exec.CuckooJobGroup;
import com.wjs.schedule.enums.CuckooBooleanFlag;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.enums.CuckooJobExecType;
import com.wjs.schedule.enums.CuckooJobStatus;
import com.wjs.schedule.enums.CuckooJobTriggerType;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.qry.job.JobInfoQry;
import com.wjs.schedule.service.job.CuckooGroupService;
import com.wjs.schedule.service.job.CuckooJobDependencyService;
import com.wjs.schedule.service.job.CuckooJobNextService;
import com.wjs.schedule.service.job.CuckooJobService;
import com.wjs.schedule.vo.job.CuckooJobDetailVo;
import com.wjs.util.DateUtil;
import com.wjs.util.bean.PropertyUtil;
import com.wjs.util.config.ConfigUtil;
import com.wjs.util.dao.PageDataList;


/**
 * index controller
 */
@Controller
@RequestMapping("/jobinfo")
public class JobInfoController extends BaseController{


	@Autowired
	CuckooJobService cuckooJobService;
	
	@Autowired
	CuckooGroupService cuckooGroupService;
	
	@Autowired
	CuckooJobNextService cuckooJobNextService;
	
	@Autowired
	CuckooJobDependencyService cuckooJobDependencyService;
	
	@Autowired
	CuckooJobExtendMapper cuckooJobExtendMapper;
	
	@RequestMapping
	public String index0(HttpServletRequest request) {
		
		return index(request);
	}
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {
		
		// 默认超时时间
		request.setAttribute("overTime", 3);
				
		
		// 默认邮件接收人
		request.setAttribute("defaltMailTo", ConfigUtil.get("mail.receive.defalt.email"));
		
		// 任务分组
		List<CuckooJobGroup> jobGroupList = cuckooGroupService.listAllGroup();
		if(CollectionUtils.isNotEmpty(jobGroupList)){
			for (CuckooJobGroup cuckooJobGroup : jobGroupList) {
				cuckooJobGroup.setGroupName(cuckooJobGroup.getId() + "-" + cuckooJobGroup.getGroupName());
			}
		}
		request.setAttribute("jobGroupList", jobGroupList);
		
		List<CuckooJobGroup> jobGroupsWithNull = new ArrayList<CuckooJobGroup>();
		CuckooJobGroup groupNull = new CuckooJobGroup();
		groupNull.setGroupName("全部/无");
		jobGroupsWithNull.add(0, groupNull);
		jobGroupsWithNull.addAll(jobGroupList);
		request.setAttribute("jobGroupsWithNull", jobGroupsWithNull);
		
		// 任务类型

		CuckooJobExecType[] jobExecTypes = CuckooJobExecType.valuesNoNull();
		request.setAttribute("execJobTypes", jobExecTypes);
		
		
		// APP应用
		Map<String,String> jobAppList = cuckooJobService.findAllApps();
		request.setAttribute("jobAppList", jobAppList);
		Map<String,String> jobAppWithNull = new HashMap<>();
		jobAppWithNull.put("", "全部/无");
		jobAppWithNull.putAll(jobAppList);
		request.setAttribute("jobAppWithNull", jobAppWithNull);
		
		
		
		// 任务状态
		CuckooJobStatus[] jobStatusList = CuckooJobStatus.values();
		request.setAttribute("jobStatusList", jobStatusList);
		
//		CuckooJobStatus[] jobStatusNoNull = CuckooJobStatus.valuesNoNull();
//		request.setAttribute("jobStatusNoNull", jobStatusNoNull);
		
		// 任务执行状态

		CuckooJobExecStatus[] jobExecStatus = CuckooJobExecStatus.values();
		request.setAttribute("jobExecStatusList", jobExecStatus);
//		CuckooJobExecStatus[] jobExecStatus = CuckooJobExecStatus.valuesNoNull();
//		request.setAttribute("jobExecStatusNoNull", jobExecStatus);
		
		// 任务触发方式
		CuckooJobTriggerType[] jobTriggerType = CuckooJobTriggerType.valuesNoNull();
		request.setAttribute("jobTriggerTypeNoNull", jobTriggerType);
		
		// 是否为日切任务
		CuckooBooleanFlag[] jobIsTypeDaily = CuckooBooleanFlag.valuesNoNull();
		request.setAttribute("jobIsTypeDailyNoNull", jobIsTypeDaily);
		
		
		
		return "jobinfo/jobinfo.index";
	}
	
	/**
	 * 分页查询任务
	 * @param jobInfo
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/pageList")
	@ResponseBody
	public Object pageList(JobInfoQry jobInfo){
		PageDataList<CuckooJobDetail> page = cuckooJobService.pageList(jobInfo);
		
		PageDataList<CuckooJobDetailVo> pageVo = convertJobDetailPageVo(page);
		return dataTable(pageVo);
	}

	private PageDataList<CuckooJobDetailVo> convertJobDetailPageVo(PageDataList<CuckooJobDetail> page) {

		PageDataList<CuckooJobDetailVo> pageVo = new PageDataList<>();
		
		pageVo.setPage(page.getPage());
		pageVo.setPageSize(page.getPageSize());
		pageVo.setTotal(page.getTotal());
		List<CuckooJobDetailVo> rows = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(page.getRows())){
			for (CuckooJobDetail jobDetail : page.getRows()) {
				CuckooJobDetailVo vo = new CuckooJobDetailVo();
				PropertyUtil.copyProperties(vo, jobDetail);
				
				if(CuckooJobTriggerType.CRON.getValue().equals(jobDetail.getTriggerType())){
					// 查看Cron是否有这个任务
					vo.setQuartzInit(cuckooJobService.checkCronQuartzInit(jobDetail));
				}
				
				// 查询其他扩展信息
				CuckooJobExtend cuckooJobExtend = cuckooJobExtendMapper.selectByPrimaryKey(jobDetail.getId());
				if(null != cuckooJobExtend){

					vo.setOverTime(cuckooJobExtend.getOverTimeLong());
					vo.setMailTo(cuckooJobExtend.getEmailList());
				}
				CuckooJobGroup jobGroup =  cuckooGroupService.getGroupById(vo.getGroupId());
				vo.setGroupName(jobGroup == null ? "" : jobGroup.getGroupName());
				
				rows.add(vo);
			}
		}
		pageVo.setRows(rows);
		
		return pageVo;
	}


	/**
	 * 根据jobId获取触发任务的id
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value="/getPreJobIdByJobId")
	@ResponseBody
	public Object getPreJobIdByJobId(Long jobId){
		
		return success(cuckooJobNextService.findJobIdByNextJobId(jobId));
	}
	
	
	
	/**
	 * 根据jobId获取任务依赖的任务IDs
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value="/getDependencyIdsByJobId")
	@ResponseBody
	public Object getDependencyIdsByJobId(Long jobId){
		
		return success(cuckooJobDependencyService.listDependencyIdsByJobId(jobId));
	}
	
	/**
	 * 暂停全部
	 * @return
	 */
	@RequestMapping(value="/paushAll")
	@ResponseBody
	public Object paushAll(JobInfoQry jobInfo){
		
		cuckooJobService.pauseAllJob(jobInfo);
		return success();
	}
	
	/**
	 * 回复全部
	 * @return
	 */
	@RequestMapping(value="/resumeAll")
	@ResponseBody
	public Object resumeAll(JobInfoQry jobInfo){

		cuckooJobService.resumeAllJob(jobInfo);
		return success();
	}
	
	/**
	 * 执行
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/trigger")
	@ResponseBody
	public Object trigger(Long id, String typeDaily, Boolean needTriggleNext, Integer txDate, String flowLastTime, String flowCurTime){
		 
		
		if(CuckooBooleanFlag.NO.getValue().equals(typeDaily)){
			
			cuckooJobService.triggerUnDailyJob(id, needTriggleNext, DateUtil.getLongTime(flowLastTime, "yyyy-MM-dd HH:mm:ss:SSS"), DateUtil.getLongTime(flowCurTime, "yyyy-MM-dd HH:mm:ss:SSS"), false);
		}else if(CuckooBooleanFlag.YES.getValue().equals(typeDaily)){

			cuckooJobService.triggerDailyJob(id, needTriggleNext, txDate, false);
		}else{
			cuckooJobService.triggerJob(id, needTriggleNext, false);
		}
		return success();
	}


	/**
	 * 暂停
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/pause")
	@ResponseBody
	public Object pause(Long id){
		
		cuckooJobService.pauseOnejob(id);
		return success();
	}
	
	/**
	 * 恢复
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/resume")
	@ResponseBody
	public Object resume(Long id){
		
		cuckooJobService.resumeOnejob(id);
		return success();
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/remove")
	@ResponseBody
	public Object remove(Long id){
		
		cuckooJobService.removeJob(id);
		return success();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(HttpServletRequest request, CuckooJobDetailVo jobDetail){
		
		// 增加执行类型必要条件判断
		if(CuckooJobExecType.CUCKOO.getValue().equals(jobDetail.getExecJobType())){
			if(StringUtils.isEmpty(jobDetail.getJobClassApplication())){
				throw new BaseException("CuckooJob's appName can not be null");
			}
		}
		
		if(CuckooJobTriggerType.JOB.getValue().equals(jobDetail.getTriggerType())){
			// 任务触发的任务，需要配置触发任务和依赖任务
			if(null == jobDetail.getPreJobId()){
				throw new BaseException("the job Triggered by another should have a preJob");
			}
			if(StringUtils.isEmpty(jobDetail.getDependencyIds()) ){
				throw new BaseException("the job Triggered by another should have more then one dependency job(the prejob can be dependencyjob)");
			}
		}
		

		if(CuckooBooleanFlag.NO.getValue().equals(jobDetail.getTypeDaily())){
			// 非日切任务，不建议有太多的依赖
			if(StringUtils.isNotEmpty(jobDetail.getDependencyIds()) && jobDetail.getDependencyIds().contains(",")){

				throw new BaseException("undaily job should not have too many dependency jobs.");
			}
		}
		
		
		if(null == jobDetail.getId()){


			cuckooJobService.addJob(jobDetail);
		}else{
			cuckooJobService.modifyJob(jobDetail);
		}
		
		
		return success();
	}
	
	
	@RequestMapping(value="/execview")
	@ResponseBody
	public Object execview(HttpServletRequest request, Long jobId){
		
		if(null == jobId){
			throw new BaseException("logid can not be null");
		}
		
		
		CuckooJobDetail cuckooJobDetail = cuckooJobService.getJobById(jobId);
		if(null == cuckooJobDetail){
			 throw new BaseException("can not get jobInfo by logid:{}", jobId);
		}
		
		Map<String, Object> rtn = new HashMap<>();
		// 查询
		Long preJobId = cuckooJobNextService.findJobIdByNextJobId(jobId);
		
		List<Long> dependencyIds = cuckooJobDependencyService.listDependencyIdsByJobId(jobId);
		
		// 依赖任务中过滤掉上级触发任务
		if(CollectionUtils.isNotEmpty(dependencyIds) && null != preJobId ){
			for (Iterator<Long> it = dependencyIds.iterator(); it.hasNext() ;) {
				Long id = it.next();
				if(preJobId.equals(id)){
					it.remove();
				}
			}
		}

		List<Long> nextJobIds = cuckooJobNextService.findNextJobIdByJobId(jobId);
		
		rtn.put("curJob", convertJobVo(jobId));
		rtn.put("depJobs", convertJobVos(dependencyIds));
		rtn.put("nextJobs", convertJobVos(nextJobIds));
		rtn.put("preJob", convertJobVo(preJobId));
		
		return success(rtn);
	}


	private List<CuckooJobDetailVo> convertJobVos(List<Long> dependencyIds) {

		List<CuckooJobDetailVo> result = new ArrayList<>();

		if(CollectionUtils.isNotEmpty(dependencyIds)){
			for (Long jobId : dependencyIds) {
				CuckooJobDetailVo vo = convertJobVo(jobId);
				if(null != vo){
					result.add(vo);
				}
			}
		}
		
		return result;
	}


	private CuckooJobDetailVo convertJobVo(Long jobId) {

		CuckooJobDetailVo vo = new CuckooJobDetailVo();

		CuckooJobDetail cuckooJobDetail = cuckooJobService.getJobById(jobId);
		if(null == cuckooJobDetail){
			return null;
		}
		PropertyUtil.copyProperties(vo, cuckooJobDetail);
		CuckooJobGroup group = cuckooGroupService.getGroupById(cuckooJobDetail.getGroupId());
		vo.setGroupName(group.getGroupName());
		return vo;
	}
		
	
}
