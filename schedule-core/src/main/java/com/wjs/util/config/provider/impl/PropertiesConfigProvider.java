package com.wjs.util.config.provider.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.wjs.util.config.provider.ConfigProvider;

/**
 * 
 * @Description: PropertyPlaceholderConfigurer配置提供者
 * @author suzy suzy@malam.com
 * @date 2014年5月6日 上午12:05:01
 * 
 *
 */
public class PropertiesConfigProvider implements ConfigProvider {

	Map<String, String> cache = new HashMap<String, String>();

	public void cacheProperties(Properties props) {
		for (Object keyObject : props.keySet()) {
			String key = keyObject.toString();
			cache.put(key, props.getProperty(key));
		}
	}

	@Override
	public String getConfig(String key) {
		return cache.get(key);
	}

	@Override
	public void init() {

	}

	@Override
	public Map<String, String> getAll() {
		return Collections.unmodifiableMap(cache);
	}

}
