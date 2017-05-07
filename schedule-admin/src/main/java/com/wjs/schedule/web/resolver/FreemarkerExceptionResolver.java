
/* 
* @author Silver
* @date 2016年1月29日 下午1:24:27 
* Copyright  ©2016 网金社
*/

package com.wjs.schedule.web.resolver;

import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * freemarker页面上的异常控制
 * 对应：freemarkerConfigurer
 * 
 * @author Silver
 * @date 2016年1月29日 下午1:24:27
 * 
 **/

public class FreemarkerExceptionResolver implements TemplateExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerExceptionResolver.class);

	public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {

		LOGGER.error("[Freemarker Error: " + te.getMessage() + "]", te);
		throw te;
	}

}
