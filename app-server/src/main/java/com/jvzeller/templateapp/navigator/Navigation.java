package com.jvzeller.templateapp.navigator;

import java.util.ArrayList;
import java.util.List;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.strategy.IStrategy;

public class Navigation < E extends DomainEntity > {

    private List < IStrategy < E > > activities;

    public Navigation () {
	this.activities = new ArrayList <> ();
    }

    public void addActivity( IStrategy < E > activity ) {
	this.activities.add ( activity );
    }

    public List < IStrategy < E > > getActivities() {
	return activities;
    }

}
