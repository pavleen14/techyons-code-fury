package com.hsbc.meets.service.impl;

import java.sql.SQLException;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.factory.LoginFactory;
import com.hsbc.meets.service.LoginService;
import com.hsbc.meets.util.Encryption;
import com.hsbc.meets.util.Validator;

public class LoginServiceImpl implements LoginService {

	@Override
	public User authentication(String email, String password)
			throws InvalidCredentialsException, ClassNotFoundException, SQLException {
		Validator validator = new Validator();
		User authenticatedUser = null;
		if (!validator.validateEmail(email) && !validator.validatePassword(password)) {
			throw new InvalidCredentialsException();

		} else {
			LoginDao loginDao = LoginFactory.getLoginDao();
			authenticatedUser = loginDao.validate(email, Encryption.md5(password));
		}
		return authenticatedUser;

	}

}
