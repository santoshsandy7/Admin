package com.ors.dao;

import org.springframework.stereotype.Service;

@Service
public class LoginDaoImpl implements LoginDao{
	public boolean validateLogin(String loginId, String pwd) {
		return (pwd.equals("admin@123") && loginId.equals("admin"));
	}

}
