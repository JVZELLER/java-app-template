package com.jvzeller.templateapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.google.common.base.Strings;

import com.jvzeller.templateapp.entity.DomainEntity;

@Component
public class Result < T extends DomainEntity > {

    private Boolean success;
    private List < String > messages = new ArrayList <> ();
    private List < T > resultList = new ArrayList <> ();

    public Result () {
	success = true;
    }

    public void setSeuccess( String message ) {
	if ( !success ) {
	    success = true;
	    messages = new ArrayList <> ();
	}

	if ( !Strings.isNullOrEmpty ( message ) ) {
	    messages.add ( message );
	}

    }

    public void setError( String message ) {
	if ( success ) {
	    success = false;
	    messages = new ArrayList <> ();
	}
	
	if ( !Strings.isNullOrEmpty ( message ) ) {
	    messages.add ( message );
	}
    }

    public Boolean getSuccess() {
	return success;
    }

    public void setSuccess( Boolean success ) {
	this.success = success;
    }

    public List < String > getMessages() {
	return messages;
    }

    public void setMessages( List < String > messages ) {
	this.messages = messages;
    }

    public List < T > getResultList() {
	return resultList;
    }

    public void setResultList( List < T > resultList ) {
	this.resultList = resultList;
    }

}
