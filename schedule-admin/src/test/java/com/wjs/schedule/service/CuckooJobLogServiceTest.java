package com.wjs.schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.ServiceUnitBaseTest;
import com.wjs.schedule.qry.QryBase;
import com.wjs.schedule.service.job.CuckooJobLogService;

public class CuckooJobLogServiceTest  extends ServiceUnitBaseTest {
	
	@Autowired 
	CuckooJobLogService cuckooJobLogService;
	@Test
	public void pagePendingList(){
		
		QryBase qry = new QryBase();
		qry.setStart(0);
		qry.setLimit(1);
		List<Long> groupIds = new ArrayList<>();
		groupIds.add(1L);
		groupIds.add(2L);
		groupIds.add(3L);
		qry.setGroupIds(groupIds);
		System.out.println(cuckooJobLogService.pagePendingList(qry));
	}

	
	@Test
	public void pageOverTimeJobs(){
		QryBase qry = new QryBase();
		qry.setStart(0);
		qry.setLimit(1);
		List<Long> groupIds = new ArrayList<>();
		groupIds.add(1L);
		groupIds.add(2L);
		groupIds.add(3L);
		qry.setGroupIds(groupIds);
		System.out.println(cuckooJobLogService.pageOverTimeJobs(qry));
	}
}
