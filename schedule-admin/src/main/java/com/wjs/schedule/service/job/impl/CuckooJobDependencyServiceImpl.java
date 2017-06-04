package com.wjs.schedule.service.job.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wjs.schedule.dao.exec.CuckooJobDependencyMapper;
import com.wjs.schedule.dao.exec.CuckooJobDetailMapper;
import com.wjs.schedule.dao.exec.CuckooJobExecLogMapper;
import com.wjs.schedule.domain.exec.CuckooJobDependency;
import com.wjs.schedule.domain.exec.CuckooJobDependencyCriteria;
import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.domain.exec.CuckooJobExecLogCriteria;
import com.wjs.schedule.enums.CuckooBooleanFlag;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.service.job.CuckooJobDependencyService;
import com.wjs.schedule.util.CuckBeanUtil;
import com.wjs.schedule.vo.job.JobDependency;
import com.wjs.util.bean.PropertyUtil;

@Service("cuckooJobDependencyService")
public class CuckooJobDependencyServiceImpl implements CuckooJobDependencyService {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooJobDependencyServiceImpl.class);


	@Autowired
	CuckooJobDependencyMapper cuckooJobDependencyMapper;
	
	@Autowired
	CuckooJobDetailMapper cuckooJobDetailMapper;
	
	@Autowired
	CuckooJobExecLogMapper cuckooJobExecLogMapper;
	
	
	@Override
	@Transactional
	public void setDependencyJobConfig(List<JobDependency> dependencyJobs) {

		if(CollectionUtils.isEmpty(dependencyJobs)){
			
			throw new BaseException("dependency jobs should not be empty : ");
		}
		// 先删除触发
		CuckooJobDependencyCriteria curJobCrt = new CuckooJobDependencyCriteria();
		curJobCrt.createCriteria().andIdEqualTo(dependencyJobs.get(0).getJobId());
		cuckooJobDependencyMapper.deleteByExample(curJobCrt);
		
		// 再增加触发
		for (JobDependency jobDependency : dependencyJobs) {
			CuckooJobDependency cuckooJobDependency = CuckBeanUtil.parseJobDependency(jobDependency);
			cuckooJobDependencyMapper.insertSelective(cuckooJobDependency);
		}
	}

	@Override
	public boolean checkDepedencyJobFinished(CuckooJobExecLog jobLog){

		CuckooJobDependencyCriteria depJobMapCrt = new CuckooJobDependencyCriteria();
		depJobMapCrt.createCriteria().andJobIdEqualTo(jobLog.getJobId());
		List<CuckooJobDependency> depJobMaps = cuckooJobDependencyMapper.selectByExample(depJobMapCrt);
		List<Long> depJobIds = PropertyUtil.fetchFieldList(depJobMaps, "dependencyJobId");
		if (CollectionUtils.isEmpty(depJobIds)) {
			return true;
		}

		// 依赖执行任务完成条件： 1.依赖的任务状态都为成功；2.日切任务的txdate需要一致、非日切任务的latestTime一致
		List<CuckooJobExecLog> readyDepJobs = null;
		if (CuckooBooleanFlag.NO.getValue().equals(jobLog.getTypeDaily())) {

			CuckooJobExecLogCriteria depJobCrt = new CuckooJobExecLogCriteria();
//			depJobCrt.setDistinct(true);
			depJobCrt.createCriteria().andJobIdIn(depJobIds)
					// 1.依赖的任务状态都为成功
					.andExecJobStatusEqualTo(CuckooJobExecStatus.SUCCED.getValue())
					// 非日切任务的latestTime一致
					.andFlowLastTimeEqualTo(jobLog.getFlowLastTime());
			readyDepJobs = cuckooJobExecLogMapper.selectByExample(depJobCrt);

		} else if(CuckooBooleanFlag.YES.getValue().equals(jobLog.getTypeDaily())){

			// 2.日切任务的txdate需要一致
			CuckooJobExecLogCriteria depLogTxdateCrt = new CuckooJobExecLogCriteria();
//			depLogTxdateCrt.setDistinct(true);
			depLogTxdateCrt.createCriteria().andJobIdIn(depJobIds)
					// 1.依赖的任务状态都为成功
					.andExecJobStatusEqualTo(CuckooJobExecStatus.SUCCED.getValue())
					// 日切任务的txdate需要一致
					.andTxDateEqualTo(jobLog.getTxDate());
			readyDepJobs = cuckooJobExecLogMapper.selectByExample(depLogTxdateCrt);

		}else{
			// 无业务日期参数，什么都不校验
			return true;
		}
		
		Set<Long> readydepJobs = new HashSet<>();
		
		if(CollectionUtils.isNotEmpty(readyDepJobs)){
			for (CuckooJobExecLog log : readyDepJobs) {
				readydepJobs.add(log.getJobId());
			}
		}
		if (readydepJobs.size() != depJobIds.size()) {
			
			

			LOGGER.debug("dependency was not ready,jobLog:{},dependyJobs:{},readydepJobs:{}", jobLog, depJobIds, readydepJobs);
//			throw new JobCanNotRunningException("dependency was not ready,jobLog:{},dependyJobs:{},readydepJobs:{}", jobLog, depJobIds, readydepJobs);
			jobLog.setRemark("dependency was not ready,dependyJobs:" + depJobIds + ",readydepJobs:" + readydepJobs);
			return false;
		}

		return true;
	}

	@Override
	public List<Long> listDependencyIdsByJobId(Long jobId) {
		
		List<Long> rtn = new ArrayList<>(0);
		CuckooJobDependencyCriteria crt = new CuckooJobDependencyCriteria();
		crt.createCriteria().andJobIdEqualTo(jobId);
		List<CuckooJobDependency> result = cuckooJobDependencyMapper.selectByExample(crt);
		if(CollectionUtils.isNotEmpty(result)){
			rtn = PropertyUtil.fetchFieldList(result, "dependencyJobId", Long.class);
		}
		return rtn;
	}

	@Override
	public void addOrUpdateJobDependency(Long jobId, String[] dependencyIds) {
		// 1.先删除
		
		CuckooJobDependencyCriteria crtDel = new CuckooJobDependencyCriteria();
		crtDel.createCriteria().andJobIdEqualTo(jobId);
		cuckooJobDependencyMapper.deleteByExample(crtDel);
		
		// 2.再增加
		for (String dependencyId : dependencyIds) {
			CuckooJobDependency jobDependency = new CuckooJobDependency();
			jobDependency.setJobId(jobId);
			CuckooJobDetail cuckooJobDetail = cuckooJobDetailMapper.selectByPrimaryKey(Long.valueOf(dependencyId));
			if(null == cuckooJobDetail){
				throw new BaseException("can not find dependency job ,jobId:{}", dependencyId);
			}
			jobDependency.setDependencyJobId(Long.valueOf(dependencyId));
			cuckooJobDependencyMapper.insertSelective(jobDependency);
		}
		
	}

}
