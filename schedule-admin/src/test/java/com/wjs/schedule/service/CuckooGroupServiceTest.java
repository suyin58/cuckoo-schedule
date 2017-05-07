package com.wjs.schedule.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.schedule.ServiceUnitBaseTest;
import com.wjs.schedule.domain.exec.CuckooJobGroup;
import com.wjs.schedule.service.job.CuckooGroupService;
import com.wjs.schedule.vo.job.JobGroup;

public class CuckooGroupServiceTest extends ServiceUnitBaseTest {

	@Autowired
	CuckooGroupService cuckooGroupService;
	
	@Test
	public void testAddGroup(){

		CuckooJobGroup group  = new CuckooJobGroup();
		group.setGroupName("单测分组");
		group.setGroupDesc("单测分组说明");
		Long id = cuckooGroupService.addGroup(group);
		System.out.println(id);
	}
}
