package com.jvzeller.templateapp.util;

import com.jvzeller.templateapp.entity.DomainEntity;

public class ResponseMessage extends Response {
    
    private String message;
    private Boolean error;
    
    public ResponseMessage(Boolean error, String message) {
	this.error = error;
	this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage( String message ) {
        this.message = message;
    }
    
    public Boolean getError() {
        return error;
    }
    
    public void setError( Boolean error ) {
        this.error = error;
    }
    
    
    
    

}
