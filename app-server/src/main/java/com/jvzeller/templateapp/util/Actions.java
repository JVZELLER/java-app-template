package com.jvzeller.templateapp.util;

public enum Actions {

    SAVE("Save"),
    UPDATE("Update"),
    DELETE("Delete"),
    FIND("Find");

    private String value;

    private Actions ( String value ) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }    
}
