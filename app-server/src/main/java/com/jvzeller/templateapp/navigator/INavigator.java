package com.jvzeller.templateapp.navigator;

import com.jvzeller.templateapp.entity.DomainEntity;

public interface INavigator < E extends DomainEntity >{

    public void run( E aEntity, INavigationCase < E > aCase );

}
