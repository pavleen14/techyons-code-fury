package com.hsbc.meets.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

/**
 * Helps implement DAO classes which
 * intends to handle the data on login page.
 * 
 * @author Muskan
 *
 */

public interface LoginDao {
	
	/**
	 * Validates user credentials from database.
	 * 
	 * @param email
	 * @param encryptedPassword
	 * @return User object after successful authentication
	 * @throws InvalidCredentialsException when authentication fails
	 */
	public User validate(String email,String encryptedPassword) throws SQLException,ClassNotFoundException, InvalidCredentialsException;
	
	
	/**
	 * Updates the last login to current timestamp
	 * after successful authentication
	 * @param id of user
	 * @param connection to database
	 *
	 */
	public void updateLastLogin(int id, Connection connection) throws SQLException;

}
