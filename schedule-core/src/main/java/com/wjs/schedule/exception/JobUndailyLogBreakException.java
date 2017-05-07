package com.wjs.schedule.exception;

import org.slf4j.helpers.MessageFormatter;

public class JobUndailyLogBreakException extends Throwable{

	private static final long serialVersionUID = 1L;

	public JobUndailyLogBreakException() {
		super();
	}


	public JobUndailyLogBreakException(String message) {
		super(message);
	}
	

	public JobUndailyLogBreakException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public JobUndailyLogBreakException(String message, Throwable cause) {
		super(message, cause);
	}



	public JobUndailyLogBreakException(Throwable cause) {
		super(cause);
	}
	
	public JobUndailyLogBreakException(String format, Object... arguments) {
		
		super(MessageFormatter.arrayFormat(format, arguments).getMessage());
	}
	
	public static void main(String[] args) {
		String[] arr = {"你好","哈哈"};
		System.out.println(MessageFormatter.arrayFormat("ninhao:{},haha:{}", arr).getMessage());
	}



}
