package com.wjs.schedule.net.client.filter;

import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

import com.wjs.schedule.constant.CuckooNetConstant;

public class CodecFilter extends ProtocolCodecFilter{
	
	public CodecFilter(){
		
		super(new TextLineCodecFactory(Charset.forName(CuckooNetConstant.ENCODING)));
	}
	

}
