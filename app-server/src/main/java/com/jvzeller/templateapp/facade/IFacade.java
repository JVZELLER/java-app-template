package com.jvzeller.templateapp.facade;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.INavigationCase;
import com.jvzeller.templateapp.util.Result;

public interface IFacade < T extends DomainEntity > {

    Result < T > save( T aEntity, INavigationCase < T > aCase );

    Result < T > update( T aEntity, INavigationCase < T > aCase );

    Result < T > delete( T aEntity, INavigationCase < T > aCase );

    Result < T > find( T aEntity, INavigationCase < T > aCase );
}
