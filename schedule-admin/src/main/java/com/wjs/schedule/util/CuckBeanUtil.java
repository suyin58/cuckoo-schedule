package com.wjs.schedule.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.domain.exec.CuckooJobDependency;
import com.wjs.schedule.domain.exec.CuckooJobNextJob;
import com.wjs.schedule.vo.job.JobDependency;
import com.wjs.schedule.vo.job.JobNext;

public class CuckBeanUtil {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CuckBeanUtil.class);

	public static CuckooJobNextJob parseJobNext(JobNext jobNext) {

		CuckooJobNextJob cuckooJobNextJob = new CuckooJobNextJob();
		cuckooJobNextJob.setJobId(jobNext.getJobId());
		cuckooJobNextJob.setNextJobId(jobNext.getNextJobId());
		return cuckooJobNextJob;
	}

	public static CuckooJobDependency parseJobDependency(JobDependency jobDependency) {
		
		CuckooJobDependency cuckooJobDependency = new CuckooJobDependency();
		cuckooJobDependency.setJobId(jobDependency.getJobId());
		cuckooJobDependency.setDependencyJobId(jobDependency.getDependencyId());
		return cuckooJobDependency;
	}

}
