package com.jvzeller.templateapp.strategy.user;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Strings;
import com.jvzeller.templateapp.entity.User;
import com.jvzeller.templateapp.navigator.INavigationCase;
import com.jvzeller.templateapp.strategy.IStrategy;

@Configuration
public class NameValidator implements IStrategy < User > {

    @Override
    public void process( User aEntity, INavigationCase < User > aCase ) {
	if ( null != aEntity ) {
	    if ( Strings.isNullOrEmpty( aEntity.getName() ) ) {
		aCase.getResult().setError( "Nome inválido!!" );
	    }
	    
	    return;
	}
	
	aCase.suspendExecution();
	aCase.getResult().setError("Usuário Inexistente!");
	return;

    }

}
