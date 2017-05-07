package com.wjs.schedule.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.wjs.schedule.enums.CuckooMessageType;

public class MessageInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private CuckooMessageType messageType;
	
	
	private Object message;


	public CuckooMessageType getMessageType() {
		return messageType;
	}


	public void setMessageType(CuckooMessageType messageType) {
		this.messageType = messageType;
	}


	public Object getMessage() {
		return message;
	}


	public void setMessage(Object message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
