package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String serviceProvider(UserDTO dto) {
		String str = service.verifyLogin(dto);
		return str;
	}

}
