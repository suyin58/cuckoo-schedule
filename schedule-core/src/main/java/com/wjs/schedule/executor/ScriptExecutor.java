package com.wjs.schedule.executor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.enums.CuckooMessageType;
import com.wjs.schedule.net.client.ClientUtil;

public class ScriptExecutor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptExecutor.class);

	public static void exec(JobInfoBean jobInfo) {

		StringBuffer cmd = new StringBuffer(jobInfo.getJobName());
//		客户端脚本执行自动追加参数：script 执行参数  配置参数(日切:txDate【yyyyMMdd】 / 非日切:flowLastTime【时间戳Long】 flowCurTime【时间戳Long】)
		if(StringUtils.isNotEmpty(jobInfo.getCuckooParallelJobArgs())){
			appendCmd(cmd, jobInfo.getCuckooParallelJobArgs());
		}
		if(jobInfo.isTypeDaily()){
			appendCmd(cmd, String.valueOf(jobInfo.getTxDate()));
		}else{
			appendCmd(cmd, String.valueOf(jobInfo.getFlowLastTime()));
			appendCmd(cmd, String.valueOf(jobInfo.getFlowCurrTime()));
		}
		
		Process p = null;
		StringBuffer sbResult = new StringBuffer();
		try {
			LOGGER.info("script ready to exec:{}", cmd.toString());
			// 执行命令
			p = Runtime.getRuntime().exec(cmd.toString());
			// 取得命令结果的输出流
			InputStream fis = p.getInputStream();
			// 用一个读输出流类去读
			InputStreamReader isr = new InputStreamReader(fis);
			// 用缓冲器读行
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			// 直到读完为止
			while ((line = br.readLine()) != null) {
				sbResult.append(line);
				sbResult.append("\n");
			}
			if(0 == p.waitFor()){
				// 发送服务端，任务执行完成
				LOGGER.info("script exec succed,script:{},jobInfo:{}", jobInfo.getJobName(), jobInfo);
				jobInfo.setErrMessage(sbResult.toString());
				ClientUtil.send(CuckooMessageType.JOBSUCCED, jobInfo);
			}else{

				InputStream errFis = p.getErrorStream();
				// 用一个读输出流类去读
				InputStreamReader errIsr = new InputStreamReader(errFis);
				// 用缓冲器读行
				BufferedReader errBr = new BufferedReader(errIsr);
				String errLline = null;
				// 直到读完为止
				while ((errLline = errBr.readLine()) != null) {
					sbResult.append(errLline);
					sbResult.append("\n");
				}
				// 发送服务端，任务执行失败
				LOGGER.error("script exec error taskName:{},error:{}", jobInfo.getJobName(), sbResult.toString());
				// 发送服务端，任务执行失败
				jobInfo.setErrMessage(sbResult.toString());
				ClientUtil.send(CuckooMessageType.JOBFAILED, jobInfo);
			}
			

		} catch (Exception e) {
			LOGGER.error("script exec unknown error taskName:{}", jobInfo.getJobName(), e);
			// 发送服务端，任务执行异常
			jobInfo.setErrMessage(e.getMessage());
			ClientUtil.send(CuckooMessageType.JOBFAILED, jobInfo);
		}finally{
			if(null != p){
				p.destroy();
			}
		}
	}

	private static void appendCmd(StringBuffer cmd, String str) {

		cmd.append(" ").append(str);
	}

}
