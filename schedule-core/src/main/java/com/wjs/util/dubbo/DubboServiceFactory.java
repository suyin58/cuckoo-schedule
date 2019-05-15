package com.wjs.util.dubbo;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.remoting.TimeoutException;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.wjs.schedule.exception.BaseException;

public class DubboServiceFactory {
    
    private static Logger LOGGER = LoggerFactory.getLogger(DubboServiceFactory.class);
    
    private static String PREFIX_ERROR_NO = "[";
    
    private static String POSTFIX_ERROR_NO = "]";
    
    private static String applitionName;
    private static String registerProtocol;
    private static String registerAddress;
    private static String registerGroup;
    private static Integer timeOut;

    public Object call(String interfaceName,String mothedName, List<DubboParameter> parameters){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applitionName);
        
        List<RegistryConfig> registries = setRegistryConfigs();

        reference.setApplication(applicationConfig);
        reference.setRegistries(registries);
        reference.setInterface(interfaceName); // 弱类型接口名
        reference.setTimeout(1000);
        reference.setGeneric(true); // 声明为泛化接口
        
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        Object result = null;
        
        try{
            result = genericService.$invoke(mothedName, getParamterTypeArr(parameters), getParamterArgArr(parameters));
        }catch(GenericException e){
            if(BaseException.class.getName().equals(e.getExceptionClass())){
                throw baseExceptionError(e.getExceptionMessage());
            }else{
                LOGGER.error("调用出错，interfaceName：" + interfaceName + ",mothedName：" + mothedName + ",args：" + parameters, e);
                throw new BaseException("调用异常");
            }
        }catch(Exception e){
        	if(e instanceof com.alibaba.dubbo.rpc.RpcException && e.getCause() instanceof com.alibaba.dubbo.remoting.TimeoutException){
        		// CuckooTask 异步通知，此处超时当做正常逻辑处理
        		return null;
        	}else  if(e instanceof NullPointerException){
                cache.destroy(reference);
                genericService = cache.get(reference);
                try{
                    result = genericService.$invoke(mothedName, getParamterTypeArr(parameters), getParamterArgArr(parameters));
                }catch(GenericException e1){
                    if(BaseException.class.getName().equals(e1.getExceptionClass())){
                        throw baseExceptionError(e1.getExceptionMessage());
                    }else{
                        LOGGER.error("调用出错，interfaceName：" + interfaceName + ",mothedName：" + mothedName + ",args：" + parameters, e);
                        throw new BaseException("调用异常");
                    }
                }catch(Exception e1){
                    LOGGER.error("调用出错，interfaceName：" + interfaceName + ",mothedName：" + mothedName + ",args：" + parameters, e);
                    throw new BaseException("调用异常");
                }
            }else{
                LOGGER.error("调用出错，interfaceName：" + interfaceName + ",mothedName：" + mothedName + ",args：" + parameters, e);
                throw new BaseException("调用异常");
            }
        }
        

        removeKeyClass(result);
        
        return result;
    }

	/**
     * 设置注册中心支持多个注册中心
     * @return
     */
    private List<RegistryConfig> setRegistryConfigs(){
        List<RegistryConfig> registryConfigs = new ArrayList<RegistryConfig>();
        String[] registerAddressArray = registerAddress.split(",");
        for(String registerAdd : registerAddressArray){
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress(registerProtocol + "://" + registerAdd);
            registryConfig.setGroup(registerGroup);
            registryConfig.setRegister(false);

            registryConfigs.add(registryConfig);
        }

        return registryConfigs;
    }
    
    /**
     * 
     * 递归移除 map 中 key == "class" 的 entry 
     * @author weicd@wjs.com email
     * @date 2016年10月20日 下午6:45:06
     * @param obj
     */
	private void removeKeyClass(Object obj) {

		if(obj instanceof Map){
            Map map = (Map)obj;
            map.remove("class");
            
            for (Object key : map.keySet()) {
            	Object value = map.get(key);
            	removeKeyClass(value);
            }
            
        } else if (obj instanceof List) {
			List list = (List) obj;
			for (Object elem : list) {
				removeKeyClass(elem);
			}
		}
		
	}

	public BaseException baseExceptionError(String detailMessage){
        String errorNo = "SYSTEM_ERROR";
        String errorMessage = "系统错误";
        BaseException e = new BaseException();
        
        if(StringUtils.isEmpty(detailMessage)){
            return null;
        }
        
        if(detailMessage.charAt(0) != PREFIX_ERROR_NO.charAt(0)){
            return e;
        }
        
        int endIndex = detailMessage.indexOf(POSTFIX_ERROR_NO);
        if(endIndex == -1){
            return e;
        }
        
        errorNo = detailMessage.substring(1, endIndex);
        if(detailMessage.length() > endIndex + 1){
            errorMessage = detailMessage.substring(endIndex + 1);
        }else{
            errorMessage = detailMessage;
        }
        
        return e;
    }
    
    private String[] getParamterTypeArr(List<DubboParameter> dubboParams){
        if(CollectionUtils.isEmpty(dubboParams)){
            return null;
        }
        
        String[] arr = new String[dubboParams.size()];
        int i = 0;
        
        for(DubboParameter param : dubboParams){
            arr[i++] = param.getParameterType();
        }
        
        return arr;
    }
    
    private Object[] getParamterArgArr(List<DubboParameter> dubboParams){
        if(CollectionUtils.isEmpty(dubboParams)){
            return null;
        }
        
        Object[] arr = new Object[dubboParams.size()];
        int i = 0;
        
        for(DubboParameter param : dubboParams){
            arr[i++] = param.getArg();
        }
        
        return arr;
    }

    public String getApplitionName() {
        return applitionName;
    }

    public void setApplitionName(String applitionName) {
        this.applitionName = applitionName;
    }

    public String getRegisterProtocol() {
        return registerProtocol;
    }

    public void setRegisterProtocol(String registerProtocol) {
        this.registerProtocol = registerProtocol;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getRegisterGroup() {
        return registerGroup;
    }

    public void setRegisterGroup(String registerGroup) {
        this.registerGroup = registerGroup;
    }

    public Integer getTimeOut(){
        return timeOut;
    }

    public void setTimeOut(Integer timeOut){
        this.timeOut = timeOut;
    }
}
