package com.wjs.schedule.controller.callback;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wjs.schedule.bean.JobInfoBean;
import com.wjs.schedule.component.cuckoo.CuckooJobCallBack;
import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.enums.CuckooMessageType;


/**
 * index controller
 */
@Controller
public class CallBackController extends BaseController{
	private static final Logger LOGGER = LoggerFactory.getLogger(CallBackController.class);
	
	@Autowired
	CuckooJobCallBack cuckooJobCallBack;
	
	@RequestMapping("/callback")
	@ResponseBody
	public String succed(HttpServletRequest request,String messageType,String message){
		
		
		JobInfoBean jobInfo = JSON.parseObject(message, JobInfoBean.class);
		if(CuckooMessageType.JOBSUCCED.getValue().equals(messageType)){
			
			cuckooJobCallBack.execJobSuccedCallBack(jobInfo);
		}else if(CuckooMessageType.JOBFAILED.getValue().equals(messageType)){
			cuckooJobCallBack.execJobFailedCallBack(jobInfo);
		}else{
			LOGGER.error("unsport job type : {}, message:{}" ,messageType , message);
		}
		
		
		return "Done";
	}
	
	
}
