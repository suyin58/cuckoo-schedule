package com.wjs.schedule.service.job;

import java.util.Date;
import java.util.List;

import com.wjs.schedule.domain.exec.CuckooJobDetail;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.exception.JobUndailyLogBreakException;
import com.wjs.schedule.qry.QryBase;
import com.wjs.schedule.qry.job.JobLogQry;
import com.wjs.util.dao.PageDataList;

public interface CuckooJobLogService {
	
	/**
	 * 新增日志
	 * @param log
	 * @return 
	 */
	public Long insertSelective(CuckooJobExecLog log);

	/**
	 * 根据日志ID获取日志信息
	 * @param id
	 * @return
	 */
	public CuckooJobExecLog getJobLogByLogId(Long id);

	/**
	 * 根据主键更新日志状态
	 * @param id
	 * @param succed
	 * @param message 
	 */
	public void updateJobLogStatusById(Long id, CuckooJobExecStatus succed, String message);


	/**
	 * 按主键修改日志
	 * @param cuckooJobExecLogs
	 */
	public void updateJobLogByPk(CuckooJobExecLog cuckooJobExecLogs);

	/**
	 * 初始化Cron类型任务触日志(如果是依赖类型的任务，有上级任务触发下级任务的时候初始化执行日志)
	 * @param cuckooJobDetail
	 * @param scheduledFireTime 
	 * @return
	 */
	public CuckooJobExecLog initSysCronJobLog(CuckooJobDetail cuckooJobDetail, Date scheduledFireTime) throws JobUndailyLogBreakException;

	/**
	 * 控制台执行非日切任务，初始化日志
	 * @param jobId
	 * @param needTriggleNext
	 * @param lastTime
	 * @param curTime
	 * @return
	 */
	public CuckooJobExecLog initUnDailyJobLog(CuckooJobDetail cuckooJobDetail, Boolean needTriggleNext, Long flowLastTime, Long flowCurTime, boolean foreTriggle);

	/**
	 * 控制台执行日切任务，初始化日志
	 * @param jobId
	 * @param needTriggleNext
	 * @param txDate
	 * @return
	 */
	public CuckooJobExecLog initDailyJobLog(CuckooJobDetail cuckooJobDetail, Boolean needTriggleNext, Integer txDate, boolean foreTriggle);

	/**
	 * 控制台执行无业务日期任务，初始化日志
	 * @param jobId
	 * @param needTriggleNext
	 * @param txDate
	 * @return
	 */
	public CuckooJobExecLog initJobLog(CuckooJobDetail cuckooJobDetail, Boolean needTriggleNext, boolean foreTriggle);
	/**
	 * 任务执行日志分页查询
	 * @param qry
	 * @return
	 */
	public PageDataList<CuckooJobExecLog> pageByQry(JobLogQry qry);

	/**
	 * 修改任务状态
	 * @param logId
	 * @param succed
	 */
	public void resetLogStatus(Long logId, CuckooJobExecStatus succed);

	/**
	 * 查询超时任务
	 * @param overTime
	 * @param start
	 * @param limit
	 * @return
	 */
	public PageDataList<CuckooJobExecLog> pageOverTimeJobs(QryBase qry);

	/**
	 * 检查上一个任务是否执行成功
	 * @param jobLog
	 * @return
	 */
	public boolean checkPreLogIsDone(CuckooJobExecLog jobLog);

	/**
	 * 查询Pending || Running 状态任务（任务状态不是暂停状态的）
	 * @param qry
	 * @return
	 */
	public PageDataList<CuckooJobExecLog> pagePendingList(QryBase qry);

	/**
	 * 获得触发任务执行状态
	 * @param cuckooJobExecLog
	 * @return
	 */
	public CuckooJobExecLog getPreJobLogs(CuckooJobExecLog cuckooJobExecLog);

	/**
	 * 获得依赖任务执行日志
	 * @param cuckooJobExecLog
	 * @return
	 */
	public List<CuckooJobExecLog> getDependencyJobs(CuckooJobExecLog cuckooJobExecLog);

	/**
	 * 获得下级任务日志
	 * @param cuckooJobExecLog
	 * @return
	 */
	public List<CuckooJobExecLog> getNextJobs(CuckooJobExecLog cuckooJobExecLog);

	
}
