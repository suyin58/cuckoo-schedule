package com.wjs.schedule.net.server.filter;

import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

import com.wjs.schedule.constant.CuckooNetConstant;

public class CodecFilter extends ProtocolCodecFilter{
	
	public CodecFilter(){ 
		super(new TextLineCodecFactory(Charset.forName(CuckooNetConstant.ENCODING)){
			{
				setDecoderMaxLineLength(1024 * 1024);//1M  
				setEncoderMaxLineLength(1024 * 1024);//1M  
			}
		});
	}
	

}
