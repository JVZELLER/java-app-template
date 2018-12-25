package com.jvzeller.templateapp.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvzeller.templateapp.entity.DomainEntity;
import com.jvzeller.templateapp.entity.User;

public abstract class AbstractController< T extends DomainEntity > extends BaseController {
	
	protected Class<? extends T> clazz;

	public AbstractController(Class<? extends T> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<? extends DomainEntity> doSome() throws InstantiationException, IllegalAccessException {
		User user = new User();
		user.setName("José Zeller");
		user.setBirthDay(LocalDate.now());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
