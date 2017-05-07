package com.wjs.schedule.executor.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * mysql的for update no wait 实现注解
 * PS: 使用是需要确保Spring将com.wjs.common.aspectj.LockForUpdateWaitAspect注入到了环境中
 *     可以通过：<context:component-scan base-package="com.wjs.common.aspectj" /> 自动扫描注入
 * @author Silver
 * @date 2017年1月15日 下午6:22:52 
 * 
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CuckooTask {

	/**
	 * 任务名称，每个应用中的任务名称不能重复
	 * @return
	 * @author Silver 
	 * @date 2017年1月15日 下午5:00:22
	 */
	String value() default "";
	
	
}
