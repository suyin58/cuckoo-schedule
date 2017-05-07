package com.wjs.schedule.controller.jobclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.schedule.controller.BaseController;
import com.wjs.schedule.domain.net.CuckooNetClientInfo;
import com.wjs.schedule.domain.net.CuckooNetRegistJob;
import com.wjs.schedule.domain.net.CuckooNetServerInfo;
import com.wjs.schedule.qry.net.JobNetQry;
import com.wjs.schedule.service.job.CuckooJobService;
import com.wjs.schedule.service.net.CuckooNetService;
import com.wjs.schedule.vo.net.CuckooNetRegistJobVo;
import com.wjs.schedule.web.util.JqueryDataTable;
import com.wjs.util.bean.PropertyUtil;
import com.wjs.util.dao.PageDataList;

@Controller
@RequestMapping("/jobclient")
public class JobClientController  extends BaseController{


	@Autowired
	CuckooJobService cuckooJobService;
	
	@Autowired
	CuckooNetService cuckooNetService;
	@RequestMapping
	public String index0(HttpServletRequest request) {
		
		return index(request);
	}
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request) {
		
		// APP应用
		Map<String,String> jobAppList = cuckooJobService.findAllApps();
		Map<String,String> jobAppWithNull = new HashMap<>();
		jobAppWithNull.put("", "全部/无");
		jobAppWithNull.putAll(jobAppList);
		request.setAttribute("jobAppWithNull", jobAppWithNull);
		
		return "jobclient/jobclient.index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/pageList")
	public Object pageList(JobNetQry qry){
	
		PageDataList<CuckooNetRegistJob> page = cuckooNetService.pageRegistJob(qry);
		
		List<CuckooNetRegistJobVo> rows = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(page.getRows())){
			for (CuckooNetRegistJob r : page.getRows()) {
				CuckooNetRegistJobVo vo = new CuckooNetRegistJobVo();
				PropertyUtil.copyProperties(vo, r);
				
				// 客户端执行器信息
				vo.setClients(getCuckooClients(r));
				
				// 服务端信息
				vo.setServers(getCuckooServers(r));
				rows.add(vo);
			}
		}
		
		PageDataList<CuckooNetRegistJobVo> pages = new PageDataList<>();
		pages.setPage(page.getPage());
		pages.setPageSize(page.getPageSize());
		pages.setTotal(page.getTotal());
		pages.setRows(rows);
		
		return dataTable(pages);
	}
	
	private Set<String> getCuckooServers(CuckooNetRegistJob job) {

		Set<String> serverAddrs = new HashSet<>();
		List<CuckooNetServerInfo> servers = cuckooNetService.getCuckooServersByRegistJob(job);
		if(CollectionUtils.isNotEmpty(servers)){

			for (CuckooNetServerInfo cuckooNetServerInfo : servers) {
				serverAddrs.add(cuckooNetServerInfo.getId() + ":" + cuckooNetServerInfo.getIp() + "-" + cuckooNetServerInfo.getPort());
			}
		}
		
		
		return serverAddrs;
	}


	private Set<String> getCuckooClients(CuckooNetRegistJob job) {

		Set<String> clientAddrs = new HashSet<>();
		List<CuckooNetClientInfo> clients = cuckooNetService.getCuckooClientsByRegistJob(job);
		if(CollectionUtils.isNotEmpty(clients)){

			for (CuckooNetClientInfo cuckooNetClientInfo : clients) {
				clientAddrs.add(cuckooNetClientInfo.getIp() + ":" + cuckooNetClientInfo.getClientTag());
			}
		}
		return clientAddrs;
	}


	/**
	 * parse PageDataList to JqueryDataTable
	 * @param page
	 * @return
	 */
	public <T> JqueryDataTable<T>  dataTable(PageDataList<T> page) {
		JqueryDataTable<T> t = new JqueryDataTable<>();
		t.setRecordsFiltered(page.getTotal());
		t.setRecordsTotal(page.getTotal());

		t.setData(page.getRows());
		
		return t;
	}
}
