package com.wjs.schedule.quartz;

import org.junit.Test;

import com.wjs.schedule.ServiceUnitBaseTest;

public class Quartz1StartTest extends ServiceUnitBaseTest{

	@Test
	public void test(){
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
