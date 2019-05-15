package com.wjs.schedule.service.net.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.enums.CuckooJobExecType;
import com.wjs.schedule.exception.JobCanNotRunningException;
import com.wjs.schedule.exception.JobRunningErrorException;
import com.wjs.schedule.service.job.CuckooJobService;
import com.wjs.schedule.service.net.CuckooNetService;
import com.wjs.schedule.vo.job.CuckooClientJobExecResult;
import com.wjs.util.dubbo.DubboParameter;
import com.wjs.util.dubbo.DubboServiceFactory;
import com.wjs.util.http.HttpClientUtils;

@Service("cuckooServerService")
public class CuckooNetServiceImpl implements CuckooNetService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuckooNetServiceImpl.class);

	@Autowired
	CuckooJobService cuckooJobService;

	
	@Autowired
	DubboServiceFactory dubboServiceFactory;
	
	public static void main(String[] args) {
		Map<String, Object> params = new HashMap<>(8);
		params.put("jobLogId", 296L);
		params.put("jobId", 2);
//		params.put("execType", jobBean.getExecType().getValue());
//		params.put("typeDaily", jobBean.isTypeDaily());
		params.put("jobClassApplication", "http://127.0.0.1:8280/test/succed");
		params.put("jobName", "");
		params.put("needTrigglerNext", true);
		
		params.put("cuckooParallelJobArgs", "执行参数");
//		params.put("txDate", null);
		params.put("flowLastTime", 1557306600000L);
		params.put("flowCurrTime", 1557306240000L);
		// HTTP类型任务
		String url = "http://127.0.0.1:8280/test/succed";
		
		try {
			System.out.println(HttpClientUtils.post(url, params,"UTF-8","UTF-8",100000,100000));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CuckooClientJobExecResult execRemoteJob(JobInfoBean jobBean)
			throws JobCanNotRunningException, JobRunningErrorException {
		LOGGER.info("接口调用请求-->{}" ,jobBean);

		CuckooClientJobExecResult result = new CuckooClientJobExecResult();
		result.setRemark("");
		if(CuckooJobExecType.DUBBO.getValue().equals(jobBean.getExecType().getValue())){
			// Dubbo类型任务
			List<DubboParameter> parameters = new ArrayList<DubboParameter>();
			DubboParameter jobInfoBean = new DubboParameter("com.wjs.schedule.bean.JobInfoBean", jobBean);
			parameters.add(jobInfoBean);
			

			Object res = null;
			try {
				res = dubboServiceFactory.call(jobBean.getJobClassApplication(), jobBean.getJobName(), parameters);
			} catch (Exception e) {
				result.setRemark("接口调用异常：" + e.getMessage());
				LOGGER.error("接口调用异常{0}", e.getMessage(), e);
				throw new JobRunningErrorException(e.getMessage());
			}
			if(res != null){
				String resObj = JSON.toJSONString(res);
				// 对象转化成list
				result.setRemark(resObj);
			}
		}else if(CuckooJobExecType.HTTP.getValue().equals(jobBean.getExecType().getValue())){
			
			Map<String, Object> params = new HashMap<>(8);
			if(jobBean.getJobLogId() != null)params.put("jobLogId", jobBean.getJobLogId());
			if(jobBean.getJobId() != null)params.put("jobId", jobBean.getJobId());
//			params.put("execType", jobBean.getExecType().getValue());
//			params.put("typeDaily", jobBean.isTypeDaily());
			if(jobBean.getJobClassApplication() != null)params.put("jobClassApplication", jobBean.getJobClassApplication());
			if(jobBean.getJobName() != null)params.put("jobName", jobBean.getJobName());
			if(jobBean.getNeedTrigglerNext() != null)params.put("needTrigglerNext", jobBean.getNeedTrigglerNext());
			if(jobBean.getCuckooParallelJobArgs() != null)params.put("cuckooParallelJobArgs", jobBean.getCuckooParallelJobArgs());
			if(jobBean.getTxDate() != null)params.put("txDate", jobBean.getTxDate());
			if(jobBean.getFlowLastTime() != null)params.put("flowLastTime", jobBean.getFlowLastTime());
			if(jobBean.getFlowCurrTime() != null)params.put("flowCurrTime", jobBean.getFlowCurrTime());
			// HTTP类型任务
			String url = jobBean.getJobClassApplication().toLowerCase();
			
			if(url.startsWith("http")){
				try {
					
					result.setRemark(HttpClientUtils.post(url, params,"UTF-8","UTF-8",1000,1000));
				}catch (Exception e) {
					if(e instanceof java.lang.RuntimeException && e.getCause() instanceof java.net.SocketTimeoutException){
						// CuckooTask 异步通知，此处超时当做正常逻辑处理
		        		return null;
					}
					result.setRemark("error:" + e.getMessage());
					LOGGER.error("job exec error:{}", e.getMessage(), e);
					throw new JobRunningErrorException(e.getMessage());
				}
			}else if(url.startsWith("https")){
				
				try {
					result.setRemark(HttpClientUtils.postSSL(url, params,"UTF-8","UTF-8",100000,100000));
				} catch (IOException e) {
					result.setRemark("error:" + e.getMessage());
					LOGGER.error("job exec error:{}", e.getMessage(), e);
					throw new JobRunningErrorException(e.getMessage());
				}
			}else{
				throw new JobRunningErrorException("HTTP url format error,need start with http or https:" + jobBean.getJobClassApplication());
			}
		}else{
			throw new JobCanNotRunningException("Unknow jobExecType execType:" + jobBean);
		}
		
//		// 根据remoteJobExec 获取socket,
//		IoClientInfo socket = JobClientSessionCache.get(cuckooNetClientInfo.getId());
//		// 意外情况获取不到socket
//		if (socket == null) {
//			result.setRemark("JobClientSessionCache can not get socket,netclient id:" + cuckooNetClientInfo.getId());
//			throw new JobCanNotRunningException("JobClientSessionCache can not get socket,netclient id:{}",
//					cuckooNetClientInfo.getId());
//		}
//
//		// 更新远程服务器最新调用时间
//		try {
//			// socket写数据,触发客户端任务调度
//			LOGGER.info("调用远程任务开始,jobApp:{},jobName:{},bean:{}", cuckooNetClientInfo.getIp(),
//					cuckooNetClientInfo.getPort(), jobBean);
//			ServerUtil.send(socket, CuckooMessageType.JOBDOING, jobBean);
//			result.setSuccess(true);
//			result.setRemark("running");
//			return result;
//		} catch (Exception e) {
//			result.setRemark("error:" + e.getMessage());
//			LOGGER.error("job exec error:{}", e.getMessage(), e);
//			throw new JobRunningErrorException("job exec error:{}", e.getMessage());
//		}
		
		return result;

	}


}
