package com.wjs.schedule.controller.index;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.CronExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.enums.CuckooAdminPages;
import com.wjs.schedule.exception.BaseException;


/**
 * index controller
 */
@Controller
public class IndexController extends BaseController{

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		
		return redict(CuckooAdminPages.INDEX.getValue());
	}
	
	@RequestMapping("/crontab")
	public String crontab(HttpServletRequest request){
		
		return "/crontab";
	}
	
	@ResponseBody
	@RequestMapping("/calcLastRuntime")
	public Object calcLastRuntime(HttpServletRequest request, String cronExpression){
		
		
		List<String> list = new ArrayList<>();
		try {
			
			CronExpression exp = new CronExpression(cronExpression);
			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
            Date d = new Date();  
            int i = 0;  
            // 循环得到接下来n此的触发时间点，供验证  
            while (i < 5) {  
                d = exp.getNextValidTimeAfter(d);  
                if(null == d){
                	break;
                }
                list.add(df.format(d));
                ++i;  
            }  
		} catch (ParseException e) {
			
			throw new BaseException("ERROR:{}, cronExp:{}", e.getMessage(), cronExpression);
		}
		if(CollectionUtils.isEmpty(list)){
			throw new BaseException("can not get nearest 5 exec time, cronExp:{}", cronExpression);
		}
		
		return success(list);
	}
	
}
