package com.wjs.schedule.service.job;

import java.util.List;

import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.vo.job.JobDependency;

public interface CuckooJobDependencyService {

	/**
	 * 设置依赖
	 */
	public void setDependencyJobConfig(List<JobDependency> dependencyJobs);

	/**
	 * 检查任务依赖状态
	 * @param jobInfo
	 * @param data
	 */
	public boolean checkDepedencyJobFinished(CuckooJobExecLog jobInfo);
	
	/**
	 * 检查除触发任务外，其他任务是否完成
	 * @param cuckooJobDetail
	 * @param jobLog
	 * @return
	 * @author Silver 
	 * @date 2019年5月9日 上午11:09:32
	 */
	public boolean checkDepedencyJobFinished(CuckooJobDetail curJob, CuckooJobExecLog triggerJobLog);

	/**
	 * 根据任务ID查找任务依赖的其他任务ID
	 * @param jobId
	 * @return
	 */
	public List<Long> listDependencyIdsByJobId(Long jobId);
	
	/**
	 * 根据任务ID，查询任务后续的其他任务ID
	 * @param jobId
	 * @return
	 * @author Silver 
	 * @date 2019年5月10日 上午9:11:59
	 */
	public List<Long> listNextIdsByJobId(Long jobId);

	/**
	 * 先删除后增加
	 * @param jobId
	 * @param dependencyIds
	 */
	public void addOrUpdateJobDependency(Long jobId, String[] dependencyIds);


	
}
