package com.wjs.util.dubbo;

import java.io.Serializable;

public class DubboParameter implements Serializable {
    
    private static final long serialVersionUID = -978325556686377091L;
    
    private String parameterType;
    
    private Object arg;
    
    public DubboParameter(){
        
    }
    
    public DubboParameter(String parameterType, Object arg){
        this.parameterType = parameterType;
        this.arg = arg;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }
    
    @Override
    public String toString(){
        return "parameterType:" + parameterType + ",arg:" + arg;
    }

}
