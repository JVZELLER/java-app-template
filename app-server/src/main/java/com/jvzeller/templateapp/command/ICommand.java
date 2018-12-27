package com.jvzeller.templateapp.command;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.INavigationCase;
import com.jvzeller.templateapp.util.Result;

public interface ICommand < T extends DomainEntity > {

    public Result < T > execute( T aEntity, INavigationCase < T > aCase );

}
