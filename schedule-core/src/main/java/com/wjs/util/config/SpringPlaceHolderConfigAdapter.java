package com.wjs.util.config;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.wjs.util.config.provider.ConfigProvider;
import com.wjs.util.config.provider.impl.PropertiesConfigProvider;

/**
 * 
 * @Description: 获取配置工具类
 * @author suzy suzy@malam.com
 * @date 2014年3月6日 下午2:08:17
 *
 */
public class SpringPlaceHolderConfigAdapter extends PropertyPlaceholderConfigurer {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringPlaceHolderConfigAdapter.class);

	@Override
	protected void loadProperties(Properties props) throws IOException {
		long t1 = System.currentTimeMillis();
		super.loadProperties(props);
		PropertiesConfigProvider propertiesConfigProvider = new PropertiesConfigProvider();
		propertiesConfigProvider.cacheProperties(props);
		ConfigUtil.setPropertiesConfigProvider(propertiesConfigProvider);

		ConfigUtil.init();
		if (null != props) {
			for (Entry<String, String> entry : ConfigUtil.getAllInitConfig().entrySet()) {
				LOGGER.info("INIT CONFIG {}={}", entry.getKey(), entry.getValue());
				if (null != entry.getValue()) {
					props.put(entry.getKey(), entry.getValue());
				}
			}
		}

		LOGGER.info("load properties completed in " + (System.currentTimeMillis() - t1) + " ms.");
	}



	/**
	 * 
	 * 设置集中配置提供者（可以是zookeeper、redis等的实现）
	 * 
	 * @param centralConfigProvider
	 * @author huhai huhai@malam.com
	 * @date 2014年5月6日 下午10:35:28
	 */
	public void setCentralConfigProvider(ConfigProvider centralConfigProvider) {
		ConfigUtil.setCentralConfigProvider(centralConfigProvider);
	}

	/**
	 * 
	 * 设置配置源提供者列表，此设置将替换掉默认全部的数据源提供者，此功能仅供自定义配置源时使用
	 * 
	 * @param providers
	 * @author huhai huhai@malam.com
	 * @date 2014年5月7日 上午11:10:03
	 */
	public void setProviders(List<ConfigProvider> providers) {
		if (null != providers && !providers.isEmpty()) {
			ConfigUtil.setProviders(providers);
		}
	}
}
