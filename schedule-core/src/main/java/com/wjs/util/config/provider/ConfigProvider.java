package com.wjs.util.config.provider;

import java.util.Map;

/**
 * 
 * @Description: 配置提供者接口
 * @author suzy suzy@malam.com
 * @date 2014年5月5日 下午9:06:06
 * 
 *
 */
public interface ConfigProvider {

	/**
	 * 
	 * 获取配置
	 * 
	 * @param key
	 * @return 获取不到时返回null
	 * @author huhai huhai@malam.com
	 * @date 2014年5月6日 下午11:07:48
	 */
	String getConfig(String key);

	/**
	 * 
	 * 获取全部配置
	 * 
	 * @return
	 * @author huhai huhai@malam.com
	 * @date 2014年5月6日 下午11:08:37
	 */
	Map<String, String> getAll();

	/**
	 * 
	 * 初始化方法
	 * 
	 * @author huhai huhai@malam.com
	 * @date 2014年5月6日 下午11:08:52
	 */
	void init();
}
