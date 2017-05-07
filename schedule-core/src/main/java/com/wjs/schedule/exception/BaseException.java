package com.wjs.schedule.exception;

import org.slf4j.helpers.MessageFormatter;

public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}


	public BaseException(String message) {
		super(message);
	}
	

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}



	public BaseException(Throwable cause) {
		super(cause);
	}
	
	public BaseException(String format, Object... arguments) {
		
		super(MessageFormatter.arrayFormat(format, arguments).getMessage());
	}
	
	public static void main(String[] args) {
		String[] arr = {"你好","哈哈"};
		System.out.println(MessageFormatter.arrayFormat("ninhao:{},haha:{}", arr).getMessage());
	}



}
