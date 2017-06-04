package com.wjs.schedule.service.job;

import java.util.List;
import java.util.Map;

import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.qry.job.JobInfoQry;
import com.wjs.schedule.vo.job.CuckooJobDetailVo;
import com.wjs.util.dao.PageDataList;

/**
 * 任务执行服务接口
 * @author Silver
 *
 */
public interface CuckooJobService {
	
	
	
	/**
	 * 新增一个任务,返回任务id
	 */
	public Long addJob(CuckooJobDetailVo jobInfo);
	

	/**
	 * 删除一个任务
	 */
	public void removeJob(Long id);
	
	/**
	 * 修改一个任务
	 */
	public void modifyJob(CuckooJobDetailVo jobInfo);
	
	
	
	/**
	 * 暂停一个任务
	 */
	public void pauseOnejob(Long id);
	
	/**
	 * 暂停所有任务
	 */
	public void pauseAllJob(JobInfoQry jobInfo);
	
	/**
	 * 恢复一个任务
	 */
	public void resumeOnejob(Long id);
	
	/**
	 * 恢复所有任务
	 */
	public void resumeAllJob(JobInfoQry jobInfo);
	
	/**
	 * 将任务重置为PENDING状态 -- 返回最新任务的ID
	 * @param data 
	 * @param jobGroup
	 * @param jobName
	 */
	public Long pendingJob(CuckooJobDetail jobDetail, CuckooJobExecLog fatherJobLog);
	

	/**
	 * Pending任务执行的时候，发现还不具备执行任务的条件，因此重新放回pending队列
	 * @param cuckooJobExecLog
	 */
	public void rependingJob(CuckooJobExecLog jobLog);


	/**
	 * 根据ID查询任务明细
	 * @param jobId
	 * @return
	 */
	public CuckooJobDetail getJobById(Long jobId);


//	/**
//	 * 执行Debug任务
//	 */
//	public void tryTrigglePendingJob();


	/**
	 * 根据ID查询下级带触发任务
	 * @param jobId
	 * @return
	 */
	public List<CuckooJobDetail> getNextJobById(Long jobId);

	/**
	 * 分页查询任务数据
	 * @param jobInfo
	 * @param start
	 * @param length
	 * @return
	 */
	public PageDataList<CuckooJobDetail> pageList(JobInfoQry jobInfo);


	/**
	 * 查询所有客户端应用名称
	 * @return
	 */
	public Map<String,String> findAllApps();

	
	/**
	 * 手工触发非日切任务
	 * @param id
	 * @param needTriggleNext
	 * @param longTime
	 * @param longTime2
	 */
	public void triggerUnDailyJob(Long jobId, Boolean needTriggleNext, Long lastTime, Long curTime, boolean foreTriggle);


	/**
	 * 手工触发日切任务
	 * @param id
	 * @param needTriggleNext
	 * @param txDate
	 */
	public void triggerDailyJob(Long jobId, Boolean needTriggleNext, Integer txDate, boolean foreTriggle);



	/**
	 * 执行任务，无执行业务日期参数
	 * @param id
	 * @param needTriggleNext
	 * @param b
	 */
	public void triggerJob(Long jobId, Boolean needTriggleNext, boolean foreTriggle);

	/**
	 * 根据GroupId查询出任务信息
	 * @param groupId
	 * @return
	 */
	public List<CuckooJobDetail> getJobsByGroupId(Long groupId);


	/**
	 * 检查Cron任务是否初始化quartz信息
	 * @param jobDetail
	 */
	public boolean checkCronQuartzInit(CuckooJobDetail jobDetail);


	
	
}
