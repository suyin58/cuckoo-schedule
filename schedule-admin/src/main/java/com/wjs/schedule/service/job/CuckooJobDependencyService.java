package com.wjs.schedule.service.job;

import java.util.List;

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
	 * 根据任务ID查找任务依赖的其他任务ID
	 * @param jobId
	 * @return
	 */
	public List<Long> listDependencyIdsByJobId(Long jobId);

	/**
	 * 先删除后增加
	 * @param jobId
	 * @param dependencyIds
	 */
	public void addOrUpdateJobDependency(Long jobId, String[] dependencyIds);
}
