package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bo.UserBO;
import com.app.dao.LoginDAO;
import com.app.dto.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;

	@Override
	public String verifyLogin(UserDTO dto) {
		UserBO bo = null;
		int count = 0;
		bo = new UserBO();
		BeanUtils.copyProperties(dto, bo);
		count = dao.verifyUser(bo);
		if (count == 0)
			return "Authentation fail...";
		else
			return "Authentation Successfull....";
	}

}
