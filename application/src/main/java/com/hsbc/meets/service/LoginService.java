package com.hsbc.meets.service;

import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

/**
 * Helps implement Service class which
 * intends to handle the business 
 * logic of user authentication.
 *
 * @author Muskan
 *
 */
public interface LoginService {
	/**
	 * Authenticates user.
	 * 
	 * @param email
	 * @param password
	 * 
	 * @return authenticated User object
	 * 
	 * @throws InvalidCredentialsException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User authentication(String email, String password) throws InvalidCredentialsException, ClassNotFoundException,SQLException;
}
