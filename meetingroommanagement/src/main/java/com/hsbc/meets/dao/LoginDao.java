package com.hsbc.meets.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

/**
 * Helps implement DAO classes which
 * intends to handle the data on login page.
 * @author welcome
 *
 */

public interface LoginDao {
	/**
	 * This method is for validating user credentials
	 * @param email
	 * @param encryptedPassword
	 * @return authenticated user object
	 * @throws InvalidCredentialsException
	 */
	public User validate(String email,String encryptedPassword)throws SQLException,ClassNotFoundException, InvalidCredentialsException;
	/**
	 * This method is for updating the last logged in for authenticated user 
	 * @param id
	 * @param con
	 *
	 */
	public void updateLastLogin(int id, Connection con) throws SQLException;

}
