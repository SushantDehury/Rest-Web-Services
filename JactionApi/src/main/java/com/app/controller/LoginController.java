package com.app.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.LoginService;

@RestController
@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping("/home")
	public String getP() {
		return "login";
	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String serviceProvider(UserDTO dto) {
		String str = service.verifyLogin(dto);
		return str;
	}

}
