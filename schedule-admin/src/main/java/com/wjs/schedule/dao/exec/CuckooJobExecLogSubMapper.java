package com.wjs.schedule.dao.exec;

import java.util.List;

import com.wjs.schedule.domain.exec.CuckooJobExecLog;
import com.wjs.schedule.qry.QryBase;

public interface CuckooJobExecLogSubMapper {

	Integer countOverTimeJobs(QryBase qry);

	List<CuckooJobExecLog> pageOverTimeJobs(QryBase qry);

	List<CuckooJobExecLog> pagePendingJobs(QryBase qry);

	Integer countPendingJobs(QryBase qry);}