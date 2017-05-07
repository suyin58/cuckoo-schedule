package com.wjs.schedule.service.job;

import java.util.List;

import com.wjs.schedule.vo.job.JobNext;

public interface CuckooJobNextService {


	/**
	 * 设置触发的后续任务
	 */
	public void setNextJobConfig(List<JobNext> nextJobs);

	/**
	 * 根据上级任务ID查询下级任务id
	 * @param jobId
	 * @return
	 */
	public List<Long> findNextJobIdByJobId(Long jobId);

	/**
	 * 根据下级任务ID查询上级任务ID
	 * @param id
	 * @return
	 */
	public Long findJobIdByNextJobId(Long id);

	/**
	 * 新增触发任务关系
	 * @param preJobId
	 * @param jobId
	 */
	public void addOrUpdate(Long jobId, Long nextJobId);

	/**
	 * 删除某个任务的触发任务关系
	 * @param id
	 */
	public void deletePreJob(Long id);
}
