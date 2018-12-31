package com.jvzeller.templateapp.util;

public enum Action {

    SAVE("Save"),
    UPDATE("Update"),
    DELETE("Delete"),
    FIND("Find");

    private String value;

    private Action ( String value ) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }    
}
