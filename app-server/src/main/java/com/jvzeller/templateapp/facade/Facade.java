package com.jvzeller.templateapp.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.INavigationCase;
import com.jvzeller.templateapp.navigator.INavigator;
import com.jvzeller.templateapp.util.Result;

@Component
public class Facade < T extends DomainEntity > implements IFacade<T> {

    @Autowired private INavigator<T> navigator;
    
    @Override
    public Result < T > save( T aEntity, INavigationCase < T > aCase ) {
	
	navigator.run(aEntity, aCase);
	if(aCase.getResult().isSuccess() && !aCase.isSuspendExecution()) {
	    /* TODO:
	     * - Save entity ( call repository or DAO method)
	     * - Add entity to Result
	     */
	    T saved = null; 
	    aCase.getResult().addResult( saved );
	}
	
	return aCase.getResult();
    }

    @Override
    public Result < T > update( T aEntity, INavigationCase < T > aCase ) {
	
	navigator.run(aEntity, aCase);
	if(aCase.getResult().isSuccess() && !aCase.isSuspendExecution()) {
	    /* TODO:
	     * - Update entity ( call repository or DAO method)
	     * - Add entity to Result
	     */
	    T updated = null; 
	    aCase.getResult().addResult( updated );
	}
	
	return aCase.getResult();
	
    }

    @Override
    public Result < T > delete( T aEntity, INavigationCase < T > aCase ) {
	
	navigator.run(aEntity, aCase);
	if(aCase.getResult().isSuccess() && !aCase.isSuspendExecution()) {
	    /* TODO:
	     * - Delete entity ( call repository or DAO method)
	     * - Add entity to Result
	     */
	    T deleted = null; 
	    aCase.getResult().addResult( deleted );
	}
	
	return aCase.getResult();
	
    }

    @Override
    public Result < T > find( T aEntity, INavigationCase < T > aCase ) {
	
	navigator.run(aEntity, aCase);
	if(aCase.getResult().isSuccess() && !aCase.isSuspendExecution()) {
	    /* TODO:
	     * - Find entity/entities ( call repository or DAO method)
	     * - Add entity/entities to Result
	     */
	    List< T > founded = null; 
	    aCase.getResult().setResultList( founded );
	}
	
	return aCase.getResult();
    }

    
}
