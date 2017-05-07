package com.wjs.schedule.constant;

public class CuckooJobConstant {
	
	/**
	 * 执行日志ID，用于quartz中的执行参数
	 */
//	public static final String JOB_EXEC_ID = "job_exec_id"; 
	
	/**
	 * quartz任务名称分隔符
	 */
	public static final String QUARTZ_JOBNAME_JOINT = "_";
	
	/**
	 * 重试执行任务时长
	 */
	public static final String CUCKOO_PENDING_JOB_RETRY_LONG = "cuckoo.pending.job.retry.long";
	
	
	/**
	 * 当前服务器ID（数据库ID）
	 */
	public static Long curServerId = null;
	
	
}
