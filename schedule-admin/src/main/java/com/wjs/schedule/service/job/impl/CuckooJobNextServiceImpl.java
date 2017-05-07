package com.wjs.schedule.service.job.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wjs.schedule.dao.exec.CuckooJobNextJobMapper;
import com.wjs.schedule.domain.exec.CuckooJobNextJob;
import com.wjs.schedule.domain.exec.CuckooJobNextJobCriteria;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.service.job.CuckooJobNextService;
import com.wjs.schedule.util.CuckBeanUtil;
import com.wjs.schedule.vo.job.JobNext;
import com.wjs.util.bean.PropertyUtil;

@Service("cuckooJobNextService")
public class CuckooJobNextServiceImpl implements CuckooJobNextService {


	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooJobNextServiceImpl.class);
	@Autowired
	CuckooJobNextJobMapper cuckooJobNextJobMapper;

	@Override
	@Transactional
	public void setNextJobConfig(List<JobNext> nextJobs) {
		
		if(CollectionUtils.isEmpty(nextJobs)){
			
			throw new BaseException("next jobs should not be empty : ");
		}
		// 先删除触发
		CuckooJobNextJobCriteria curJobCrt = new CuckooJobNextJobCriteria();
		curJobCrt.createCriteria().andIdEqualTo(nextJobs.get(0).getJobId());
		cuckooJobNextJobMapper.deleteByExample(curJobCrt);
		
		// 再增加触发
		for (JobNext jobNext : nextJobs) {
			CuckooJobNextJob cuckooJobNextJob = CuckBeanUtil.parseJobNext(jobNext);
			try {
				cuckooJobNextJobMapper.insertSelective(cuckooJobNextJob);
			} catch (Exception e) {
				LOGGER.error("add next job error, may be more then one job triggler job:{},it's forbidden.{}", cuckooJobNextJob.getNextJobId(), cuckooJobNextJob);
				throw new BaseException("may be more then one job triggler job:{},it's forbidden.{}", cuckooJobNextJob.getNextJobId(), cuckooJobNextJob);
			}
		}
	}

	@Override
	public List<Long> findNextJobIdByJobId(Long jobId) {
		CuckooJobNextJobCriteria curJobCrt = new CuckooJobNextJobCriteria();
		curJobCrt.createCriteria().andJobIdEqualTo(jobId);
		
		List<CuckooJobNextJob> nextJobs = cuckooJobNextJobMapper.selectByExample(curJobCrt);
		return  PropertyUtil.fetchFieldList(nextJobs, "nextJobId", Long.class);
	}

	@Override
	public Long findJobIdByNextJobId(Long nextJobId) {
		
		
		CuckooJobNextJobCriteria preJobCrt = new CuckooJobNextJobCriteria();
		preJobCrt.createCriteria().andNextJobIdEqualTo(nextJobId);
		
		List<CuckooJobNextJob> preJobs = cuckooJobNextJobMapper.selectByExample(preJobCrt);
		if(CollectionUtils.isNotEmpty(preJobs)){
			return preJobs.get(0).getJobId();
		}
		return null;
	}

	@Override
	public void addOrUpdate(Long jobId, Long nextJobId) {
		
		// 一个任务只能有一个任务触发
		
		deletePreJob(nextJobId);
//		List<CuckooJobNextJob> preJobs = cuckooJobNextJobMapper.selectByExample(preJobCrt);
//		if(CollectionUtils.isNotEmpty(preJobs)){
//			throw new BaseException("job have pre trigger job aready, prejob:{}",preJobs.get(0));
//		}
		CuckooJobNextJob cuckooJobNextJob = new CuckooJobNextJob();
		cuckooJobNextJob.setJobId(jobId);
		cuckooJobNextJob.setNextJobId(nextJobId);
		cuckooJobNextJobMapper.insert(cuckooJobNextJob);
	}

	@Override
	public void deletePreJob(Long jobId) {
		CuckooJobNextJobCriteria preJobCrt = new CuckooJobNextJobCriteria();
		preJobCrt.createCriteria().andNextJobIdEqualTo(jobId);
		cuckooJobNextJobMapper.deleteByExample(preJobCrt);
	}

}
