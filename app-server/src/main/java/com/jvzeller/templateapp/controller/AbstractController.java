package com.jvzeller.templateapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvzeller.templateapp.command.ICommand;
import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.navigator.BusinessCase;
import com.jvzeller.templateapp.navigator.BusinessCaseBuilder;
import com.jvzeller.templateapp.navigator.Navigation;
import com.jvzeller.templateapp.util.Actions;
import com.jvzeller.templateapp.util.Response;
import com.jvzeller.templateapp.util.ResponseMessage;
import com.jvzeller.templateapp.util.Result;

public abstract class AbstractController < T extends DomainEntity > extends BaseController {

    Result < T > result;
    protected Class < ? extends T > clazz;
    @Autowired List < ICommand < T > > commands;
    @Autowired private Map < String, Navigation < T > > navigatorList;

    public AbstractController ( Class < ? extends T > clazz ) {
	this.clazz = clazz;
    }

    @RequestMapping ( method = RequestMethod.GET )
    public @ResponseBody ResponseEntity < ? extends Response > doSome(@RequestBody T entity) {
	try {
        	BusinessCase<T> bCase = new BusinessCaseBuilder<T>()
        		.withName(existingNavigation("FIND_".concat(clazz.getSimpleName().toUpperCase())))
        		.build();
        	
        	return new ResponseEntity<>(run(Actions.FIND.getValue()).execute(entity, bCase), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ResponseEntity<ResponseMessage>(
		    new ResponseMessage(true, "Erro ao Realizar operação!"), HttpStatus.INTERNAL_SERVER_ERROR);
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
