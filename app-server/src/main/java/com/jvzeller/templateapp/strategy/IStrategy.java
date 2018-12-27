package com.jvzeller.templateapp.strategy;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.INavigationCase;

public interface IStrategy < T extends DomainEntity > {

    public void process( T aEntity, INavigationCase < T > aCase );
}