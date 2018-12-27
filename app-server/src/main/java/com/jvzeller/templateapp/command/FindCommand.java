package com.jvzeller.templateapp.command;

import org.springframework.stereotype.Component;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.INavigationCase;
import com.jvzeller.templateapp.util.Result;

@Component
public class FindCommand < T extends DomainEntity > extends AbstractCommand < T > {

    @Override
    public Result < T > execute( T aEntity, INavigationCase < T > aCase ) {
	return applicationFacade.find ( aEntity, aCase );
    }

    

}
