package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.bo.UserBO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private static final String USER_QUERY = "SELECT COUNT(*) FROM USERLOGIN WHERE PASSWORD=? AND USERNAME=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int verifyUser(UserBO bo) {
		int count = 0;
		count = jt.queryForObject(USER_QUERY, Integer.class, bo.getPassword(), bo.getUsername());
		return count;
	}

}
