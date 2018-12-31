package com.jvzeller.templateapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvzeller.templateapp.command.ICommand;
import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.BusinessCase;
import com.jvzeller.templateapp.navigator.BusinessCaseBuilder;
import com.jvzeller.templateapp.navigator.Navigation;
import com.jvzeller.templateapp.util.Action;
import com.jvzeller.templateapp.util.Response;
import com.jvzeller.templateapp.util.ResponseMessage;
import com.jvzeller.templateapp.util.Result;

public abstract class AbstractController < T extends DomainEntity > extends BaseController {

    protected Result < T > result;
    protected Class < ? extends T > clazz;
    @Autowired
    protected List < ICommand < T > > commands;
    @Autowired
    protected Map < String, Navigation < T > > navigatorList;
    private final static String SPLITTER = "_";

    public AbstractController ( Class < ? extends T > clazz ) {
	this.clazz = clazz;
    }

    @GetMapping
    public @ResponseBody ResponseEntity < ? extends Response > find( @RequestBody T entity ) {
	try {
	    BusinessCase < T > bCase = new BusinessCaseBuilder < T >()
		    .withName( existingNavigation(
			    Action.FIND.getValue().concat( SPLITTER ).concat( clazz.getSimpleName().toUpperCase() ) ) )
		    .build();

	    return new ResponseEntity <>( run( Action.FIND.getValue() ).execute( entity, bCase ), HttpStatus.OK );
	    
	} catch ( Exception e ) {
	    e.printStackTrace();
	    return new ResponseEntity < ResponseMessage >( new ResponseMessage( true, "Erro ao Realizar operação!" ),
		    HttpStatus.INTERNAL_SERVER_ERROR );
	}

    }

    @PostMapping
    public @ResponseBody ResponseEntity < ? extends Response > save( @RequestBody T entity ) {
	try {
	    BusinessCase < T > bCase = new BusinessCaseBuilder < T >()
		    .withName( existingNavigation(
			    Action.SAVE.getValue().concat( SPLITTER ).concat( clazz.getSimpleName().toUpperCase() ) ) )
		    .build();

	    return new ResponseEntity <>( run( Action.SAVE.getValue() ).execute( entity, bCase ), HttpStatus.OK );
	    
	} catch ( Exception e ) {
	    e.printStackTrace();
	    return new ResponseEntity < ResponseMessage >( new ResponseMessage( true, "Erro ao Realizar operação!" ),
		    HttpStatus.INTERNAL_SERVER_ERROR );
	}
    }

    @PutMapping
    public @ResponseBody ResponseEntity < ? extends Response > update( @RequestBody T entity ) {
	try {
	    BusinessCase < T > bCase = new BusinessCaseBuilder < T >().withName( existingNavigation(
		    Action.UPDATE.getValue().concat( SPLITTER ).concat( clazz.getSimpleName().toUpperCase() ) ) )
		    .build();

	    return new ResponseEntity <>( run( Action.UPDATE.getValue() ).execute( entity, bCase ), HttpStatus.OK );

	} catch ( Exception e ) {
	    e.printStackTrace();
	    return new ResponseEntity < ResponseMessage >( new ResponseMessage( true, "Erro ao Realizar operação!" ),
		    HttpStatus.INTERNAL_SERVER_ERROR );
	}
    }

    @SuppressWarnings ( "unchecked" )
    @DeleteMapping ( value = "{id}" )
    public @ResponseBody ResponseEntity < ? extends Response > delete( @PathVariable Long id ) {
	try {
	    BusinessCase < T > bCase = new BusinessCaseBuilder < T >().withName( existingNavigation(
		    Action.DELETE.getValue().concat( SPLITTER ).concat( clazz.getSimpleName().toUpperCase() ) ) )
		    .build();
	    
	    T entity = (T) Class.forName( clazz.getName() ).newInstance();
	    entity.setId( id );
	    
	    return new ResponseEntity <>( run( Action.DELETE.getValue() ).execute( entity, bCase ), HttpStatus.OK );
	    
	} catch ( Exception e ) {
	    e.printStackTrace();
	    return new ResponseEntity < ResponseMessage >( new ResponseMessage( true, "Erro ao Realizar operação!" ),
		    HttpStatus.INTERNAL_SERVER_ERROR );
	}
    }

    protected ICommand < T > run( String action ) {
	for ( ICommand < T > iCommand : commands )
	    if ( iCommand.getClass().getName().contains( action ) )
		return iCommand;
	return null;
    }

    protected String existingNavigation( String name ) {
	return navigatorList.containsKey( name ) ? name : BusinessCase.DEFAULT_CONTEXT_NAME;
    }

}
