package com.wjs.schedule.service.net;

import java.util.List;

import org.apache.mina.core.session.IoSession;

import com.wjs.schedule.bean.ClientTaskInfoBean;
import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.domain.net.CuckooNetClientInfo;
import com.wjs.schedule.domain.net.CuckooNetRegistJob;
import com.wjs.schedule.domain.net.CuckooNetServerInfo;
import com.wjs.schedule.exception.JobCanNotRunningException;
import com.wjs.schedule.exception.JobRunningErrorException;
import com.wjs.schedule.qry.net.JobNetQry;
import com.wjs.schedule.vo.job.CuckooClientJobExecResult;
import com.wjs.util.dao.PageDataList;

public interface CuckooNetService {

	/**
	 * 调用远程任务
	 * @param jobBean
	 */
	CuckooClientJobExecResult execRemoteJob(CuckooNetClientInfo cuckooNetClientInfo, JobInfoBean jobBean) throws JobCanNotRunningException, JobRunningErrorException ;
	
	/**
	 * 查询可执行远程执行器列表 -- 考虑负载均衡 
	 * @param jobId
	 * @return
	 * @throws JobCanNotRunningException 
	 */
	CuckooNetClientInfo getExecNetClientInfo(Long jobId) throws JobCanNotRunningException;
	
	/**
	 * 新增可执行远程执行器
	 * @param taskInfo 
	 * @param session 
	 */
	Long addRemote(IoSession session, ClientTaskInfoBean taskInfoCuckooClientJobDetail);

	/**
	 * 按条件查询注册任务
	 * @param qry
	 * @return
	 */
	PageDataList<CuckooNetRegistJob> pageRegistJob(JobNetQry qry);

	/**
	 * 查询某个注册任务的服务器
	 * @param job
	 * @return
	 */
	List<CuckooNetServerInfo> getCuckooServersByRegistJob(CuckooNetRegistJob job);

	
	/**
	 * 查询某个注册任务的执行器信息
	 * @param job
	 * @return
	 */
	List<CuckooNetClientInfo> getCuckooClientsByRegistJob(CuckooNetRegistJob job);

	/**
	 * 删除超时服务器、执行器信息（modify_date：心跳检测的时候会更新）
	 * @param useLessTimeLong
	 */
	void removeUselessCuckooNetMessage();

	/**
	 * 删除执行器信息
	 * @param cuckooNetClientInfo
	 */
	void removeNetClient(CuckooNetClientInfo cuckooNetClientInfo);
	
	/**
	 * 删除服务器信息
	 * @param cuckooNetClientInfo
	 */
	void removeNetServer(CuckooNetServerInfo cuckooNetServerInfo);
	
	

}
