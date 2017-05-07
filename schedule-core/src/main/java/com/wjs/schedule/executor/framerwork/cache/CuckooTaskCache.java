package com.wjs.schedule.executor.framerwork.cache;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wjs.schedule.executor.framerwork.bean.CuckooTaskBean;

/**
 * 客户端
 * @author Silver
 *
 */
public class CuckooTaskCache {

	
	private static Map<String, CuckooTaskBean> cache = new ConcurrentHashMap<>();
	
	private CuckooTaskCache(){
		
	}
	
	public static void put(String taskName, CuckooTaskBean taskBean){

		cache.put(taskName, taskBean);
	}
	
	public static boolean contains(String taskName){
		
		return cache.containsKey(taskName);
	}
	
	public static CuckooTaskBean get(String taskName){
		
		return cache.get(taskName);
	}
	
	public static void remove(String taskName){
		
		cache.remove(taskName);
	}
	
	public static Collection<CuckooTaskBean> getCache(){
		
		return cache.values();
	}
}
