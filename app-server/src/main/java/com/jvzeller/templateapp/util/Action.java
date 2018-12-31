package com.jvzeller.templateapp.util;

public enum Action {

    SAVE("SAVE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    FIND("FIND");

    private String value;

    private Action ( String value ) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }    
}
