package com.jvzeller.templateapp.navigator;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.strategy.IStrategy;

public class NavigationBuilder < E extends DomainEntity > {

    private Navigation < E > navigation;

    public NavigationBuilder () {
	this.navigation = new Navigation <> ();
    }

    public NavigationBuilder < E > next( IStrategy < E > activity ) {
	navigation.addActivity ( activity );
	return this;
    }

    public Navigation < E > build() {
	return navigation;
    }

}
