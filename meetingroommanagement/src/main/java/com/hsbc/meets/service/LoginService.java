package com.hsbc.meets.service;

import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
/**
 *  Helps implement Service class which
 * intends to handle the business logic on login page.
 *
 * @author Muskan
 *
 */

public interface LoginService {
	/**
	 * This method provides the business logic for authenticating user
	 * @param email
	 * @param password
	 * @return authenticated User
	 * @throws InvalidCredentialsException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User authentication(String email, String password) throws InvalidCredentialsException, ClassNotFoundException,SQLException;

}
