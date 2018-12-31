package com.jvzeller.templateapp.util;

public abstract class Response {
    
    /**
     * Indicates business transaction
     * status
     */
    protected Boolean success;
    
    /**
     * Indicates internal server status
     */
    protected Boolean error;

    public Response () {
	this.success = true;
    }
    
    public Boolean isSuccess () {
	return this.success;
    }
    
    public  Boolean getSuccess() {
        return success;
    }

    public void setSuccess( Boolean success ) {
        this.success = success;
    }

    public Boolean getError() {
        return error;
    }

    public void setError( Boolean error ) {
        this.error = error;
    }
    
}
