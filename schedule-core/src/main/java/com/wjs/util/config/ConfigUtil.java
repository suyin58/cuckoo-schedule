package com.wjs.util.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wjs.util.config.provider.ConfigProvider;

/**
 * 
 * 获取配置类
 * 
 * @author suzy suzy@malam.com
 * @date 2014年3月6日 下午2:08:17
 * 
 *
 */
public class ConfigUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);

	private static List<ConfigProvider> providers;
	private static ConfigProvider propertiesConfigProvider;
	private static ConfigProvider centralConfigProvider;
	private static Map<String, String> initConfig = new HashMap<String, String>();

	private ConfigUtil() {
	}

	/**
	 * 
	 * 初始化配置
	 * 
	 */
	public synchronized static void init() {
		if (null == providers) {
			providers = new ArrayList<ConfigProvider>();
			providers.add(propertiesConfigProvider);

			providers.add(centralConfigProvider);
		}

		if (CollectionUtils.isNotEmpty(providers)) {
			//初始化时优先级最高的最后压入map
			for (ConfigProvider provider : providers) {
				if (null != provider) {
					try {
						provider.init();
						Map<String, String> all = provider.getAll();
						if (null != all) {
							for (Entry<String, String> entry : provider.getAll().entrySet()) {
								String oldValue = initConfig.get(entry.getKey());
								if (null != oldValue) {
									LOGGER.warn("override config . key={} oldValue={} newValue={} currentProvider={}",
													entry.getKey(), oldValue, entry.getValue(), provider.getClass());
								}
								initConfig.put(entry.getKey(), entry.getValue());
							}
						}
						LOGGER.info("init provider success:{}", provider.getClass());
					} catch (Exception e) {
						LOGGER.error("init provider failure:{}", provider.getClass(), e);
					}

				}
			}
			//逆转顺序，获取时优先级最高的先获取
			Collections.reverse(providers);
		}

	}

	/**
	 * 
	 * 获取字符串配置
	 * 
	 * @param @param key 配置项名称
	 * @param @return 字符串|null
	 * @return String 返回类型
	 * @throws 异常说明
	 */
	public static String get(String key) {
		String val = null;

		if (null != providers && !providers.isEmpty()) {
			for (ConfigProvider provider : providers) {
				if (null != provider) {
					val = provider.getConfig(key);
					if (null != val) {
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug("get config from {} {}={}", provider.getClass(), key, val);
						}
						return val;
					}
				}
			}
		}
		return val;
	}

	/**
	 * 
	 * 获取整型配置
	 * 
	 * @param @param key 配置项名称
	 * @param @return 整数|null
	 * @return Integer 返回类型
	 * @throws 异常说明
	 */
	public static Integer getInteger(String key) {
		Object value = get(key);
		if (null == value) {
			return null;
		}

		String val = value.toString().trim();
		if (StringUtils.isNumeric(val)) {
			return Integer.valueOf(val);
		} else {
			LOGGER.warn("configuration type error. expect an integer number. " + key + "=" + val);
		}
		return null;
	}
	
	public static Integer getInteger(String key, int defaut) {
		
		Integer rtn =  getInteger(key);
		return rtn == null ? defaut : rtn;
	}

	/**
	 * 
	 * 获取长整数配置
	 * 
	 * @param key 配置项名称
	 * @return 长整数|null
	 */
	public static Long getLong(String key) {
		Object value = get(key);
		if (null == value) {
			return null;
		}

		String val = value.toString().trim();
		if (StringUtils.isNumeric(val)) {
			return Long.valueOf(val);
		} else {
			LOGGER.warn("configuration type error. expect an long number. " + key + "=" + val);
		}
		return null;
	}
	

	public static Long getLong(String key, long defaut) {

		Long rtn = getLong(key);
		return rtn == null ? defaut : rtn;
	}

	/**
	 * 
	 * 获取双精度浮点数配置
	 * 
	 * @param @param key 配置项名称
	 * @param @return 双精度小数|null
	 * @return Double 返回类型
	 * @throws 异常说明
	 */
	public static Double getDouble(String key) {
		Object value = get(key);
		if (null == value) {
			return null;
		}

		String val = value.toString().trim();
		if (val.matches("\\d+.?\\d+")) {
			return Double.valueOf(val);
		} else {
			LOGGER.warn("configuration type error. expect a double number. " + key + "=" + val);
		}
		return null;
	}


	public static Double getDouble(String key, double defaut) {
		
		Double rtn =  getDouble(key);
		return rtn == null ? defaut : rtn;
	}
	/**
	 * 
	 * 获取Boolean
	 * 
	 * @param key
	 * @return Boolean|null
	 */
	public static Boolean getBoolean(String key) {
		Object value = get(key);
		if (null == value) {
			return null;
		}

		String val = value.toString().trim();
		return Boolean.valueOf(val);
	}
	
	public static Boolean getBoolean(String key, boolean defaut) {
		
		Boolean rtn = getBoolean(key);
		return rtn == null ? defaut : rtn;
	}

	/**
	 * 
	 * 获取字符串数组
	 * 
	 * @param @param key 配置项名称
	 * @param @param separator 分隔符(正则表达式)
	 * @param @param trim 是否去掉空格
	 * @param @return 字符串数组|null
	 * @return String[] 返回类型
	 * @throws 异常说明
	 */
	public static String[] getArray(String key, String separator, boolean trim) {
		Object value = get(key);
		if (null == value) {
			return null;
		}
		String val = value.toString();
		if (trim) {
			val = val.trim();
		}
		String[] arr = val.split(separator);
		if (trim) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i].trim();
			}

			return arr;
		}
		return null;
	}

	/**
	 * 
	 * 获取字符串数组（英文分号或逗号分隔，自动去掉首尾空格）
	 * 
	 * @param @param key 配置项名称
	 * @param @return 设定文件
	 * @return String[] 返回类型
	 * @throws 异常说明
	 */
	public static String[] getArray(String key) {
		return getArray(key, "[;,]", true);
	}

	/**
	 * 
	 * 获取初始化时的全部配置 (只读)
	 * 
	 * @return
	 */
	public static Map<String, String> getAllInitConfig() {
		return Collections.unmodifiableMap(initConfig);
	}


	public static void setProviders(List<ConfigProvider> providers) {
		ConfigUtil.providers = providers;
	}

	/**
	 * 
	 * @Description: 用于支持
	 * @param propertiesConfigProvider
	 */
	public static void setPropertiesConfigProvider(ConfigProvider propertiesConfigProvider) {
		ConfigUtil.propertiesConfigProvider = propertiesConfigProvider;
	}

	/**
	 * 
	 * 设置集中配置提供者（可以是zookeeper、redis等的实现）
	 * 
	 * @param centralConfigProvider
	 */
	public static void setCentralConfigProvider(ConfigProvider centralConfigProvider) {
		ConfigUtil.centralConfigProvider = centralConfigProvider;
	}

}
