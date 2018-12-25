package com.jvzeller.templateapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvzeller.templateapp.entity.DomainEntity;

public abstract class AbstractController< T extends DomainEntity > extends BaseController {
	
	protected Class<? extends T> clazz;

	public AbstractController(Class<? extends T> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity doSome() throws InstantiationException, IllegalAccessException {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

}
