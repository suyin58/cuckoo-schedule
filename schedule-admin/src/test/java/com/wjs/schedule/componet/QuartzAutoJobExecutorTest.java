package com.wjs.schedule.componet;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.ServiceUnitBaseTest;
import com.wjs.schedule.component.quartz.QuartzJobExecutor;
import com.wjs.schedule.component.quartz.QuartzManage;
import com.wjs.schedule.constant.CuckooJobConstant;
import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.enums.CuckooJobExecStatus;
import com.wjs.schedule.exception.BaseException;
import com.wjs.schedule.qry.job.JobLogQry;
import com.wjs.schedule.service.job.CuckooJobLogService;
import com.wjs.util.dao.PageDataList;

public class QuartzAutoJobExecutorTest extends ServiceUnitBaseTest{
	
	
	@Autowired
	CuckooJobLogService cuckooJobLogService;
	
	@Autowired
	QuartzManage quartzManage;
	

	@Resource(name = "quartzScheduler")
	private Scheduler scheduler;
	
	
	@Test
	public void checkSimpleExist(){
		JobLogQry qry = new JobLogQry();
		qry.setJobStatus(Arrays.asList(new String[]{CuckooJobExecStatus.PENDING.getValue()}));
		qry.setLimit(1000);
		for(int i = 0 ; ; i++){
			qry.setStart(i * qry.getLimit());
			PageDataList<CuckooJobExecLog> page = cuckooJobLogService.pageByQry(qry);
			List<CuckooJobExecLog> logs = page.getRows();
			if(CollectionUtils.isNotEmpty(logs)){
				
				for (CuckooJobExecLog cuckooJobExecLog : logs) {
					System.out.println(cuckooJobExecLog.getId());
					if(!quartzManage.checkSimpleExist(cuckooJobExecLog)){
						System.out.println("simple job not exist:" + cuckooJobExecLog.getId());
//						quartzManage.addSimpleJob(cuckooJobExecLog, ConfigUtil.getLong(CuckooJobConstant.CUCKOO_PENDING_JOB_RETRY_LONG, 60000L) );
					}
				}
			}else{
				break;
			}
		}
	}
	
	String quartzSimpleGroup = "quartz_simple";
	
	@Test
	public void addSimpleTest(){
		CuckooJobExecLog jobLog = cuckooJobLogService.getJobLogByLogId(3146L);
		String quartzJobName = jobLog.getJobId() + CuckooJobConstant.QUARTZ_JOBNAME_JOINT + jobLog.getId();
		TriggerKey triggerKey = TriggerKey.triggerKey(quartzJobName, quartzSimpleGroup);
		JobKey jobKey = new JobKey(quartzJobName, quartzSimpleGroup);
		try {
			
			Class<? extends Job> jobClass_ = QuartzJobExecutor.class; // Class.forName(jobInfo.getJobClass());
			JobDetail jobDetail = JobBuilder.newJob(jobClass_).withIdentity(jobKey).build();
			
			SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
					.repeatMinutelyForTotalCount(1) // 只触发一次
					
//					withMisfireHandlingInstructionFireNow
//					——以当前时间为触发频率立即触发执行
//					——执行至FinalTIme的剩余周期次数
//					——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//					——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
//
//					withMisfireHandlingInstructionIgnoreMisfires
//					——以错过的第一个频率时间立刻开始执行
//					——重做错过的所有频率周期
//					——当下一次触发频率发生时间大于当前时间以后，按照Interval的依次执行剩下的频率
//					——共执行RepeatCount+1次
//
//					withMisfireHandlingInstructionNextWithExistingCount
//					——不触发立即执行
//					——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
//					——以startTime为基准计算周期频率，并得到FinalTime
//					——即使中间出现pause，resume以后保持FinalTime时间不变
//
//
//					withMisfireHandlingInstructionNowWithExistingCount
//					——以当前时间为触发频率立即触发执行
//					——执行至FinalTIme的剩余周期次数
//					——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//					——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
//
//					withMisfireHandlingInstructionNextWithRemainingCount
//					——不触发立即执行
//					——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
//					——以startTime为基准计算周期频率，并得到FinalTime
//					——即使中间出现pause，resume以后保持FinalTime时间不变
//
//					withMisfireHandlingInstructionNowWithRemainingCount
//					——以当前时间为触发频率立即触发执行
//					——执行至FinalTIme的剩余周期次数
//					——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//					——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
					
					.withMisfireHandlingInstructionNowWithExistingCount();
			SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
					.withSchedule(simpleScheduleBuilder)
					.startAt(new Date(System.currentTimeMillis())) //  设置起始时间
					.build();
			
			if(scheduler.checkExists(triggerKey)){
				scheduler.deleteJob(jobKey);
			}else{
				if(scheduler.checkExists(jobKey)){
					scheduler.deleteJob(jobKey);
				}
			}
			scheduler.scheduleJob(jobDetail, simpleTrigger);
		} catch (SchedulerException e) {
			throw new BaseException(e.getMessage());
		}
		
	
	}
}
