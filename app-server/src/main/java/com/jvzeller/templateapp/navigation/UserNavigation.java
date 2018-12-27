package com.jvzeller.templateapp.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jvzeller.templateapp.entity.User;
import com.jvzeller.templateapp.navigator.Navigation;
import com.jvzeller.templateapp.navigator.NavigationBuilder;
import com.jvzeller.templateapp.strategy.user.NameValidator;

@Configuration
public class UserNavigation {

    @Autowired
    NameValidator nameValidator;

    @Bean ( "SAVE_USER" )
    public Navigation < User > saveUser() {
	return new NavigationBuilder < User >()
		.next( nameValidator )
		.build();
    }

    @Bean ( "DELETE_USER" )
    public Navigation < User > deleteUser() {
	return new NavigationBuilder < User >()
		.next( nameValidator )
		.build();
    }
    
    @Bean ( "UPDATE_USER" )
    public Navigation < User > updateUser() {
	return new NavigationBuilder < User >()
		.next( nameValidator )
		.build();
    }

    @Bean ( "FIND_USER" )
    public Navigation < User > findUser() {
	return new NavigationBuilder < User >()
		.next( nameValidator )
		.build();
    }
}
