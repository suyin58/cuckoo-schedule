package com.wjs.schedule.exception;

import org.slf4j.helpers.MessageFormatter;

public class JobRunningErrorException extends Throwable{

	private static final long serialVersionUID = 1L;

	public JobRunningErrorException() {
		super();
	}


	public JobRunningErrorException(String message) {
		super(message);
	}
	

	public JobRunningErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public JobRunningErrorException(String message, Throwable cause) {
		super(message, cause);
	}



	public JobRunningErrorException(Throwable cause) {
		super(cause);
	}
	
	public JobRunningErrorException(String format, Object... arguments) {
		
		super(MessageFormatter.arrayFormat(format, arguments).getMessage());
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"你好","哈哈"};
		System.out.println(MessageFormatter.arrayFormat("ninhao:{},haha:{}", arr).getMessage());
	}



}
