package com.jvzeller.templateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jvzeller.templateapp.entity.User;

@Controller
@RequestMapping("${server.controller.prefix}user")
public class UserController extends AbstractController<User> {

	public UserController () {
		super(User.class);
	}
}
