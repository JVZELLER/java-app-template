package com.jvzeller.templateapp.util;

public class ResponseMessage extends Response {
    
    private String message;
    
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
    
}
