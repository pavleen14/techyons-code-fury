package com.hsbc.meets.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.EmptyUsersDataFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;

/**
 * Helps implement DAO classes which
 * intends to handle the data on homepage.
 * 
 * @author rishi
 *
 */
public interface HomeDao {
	/**
	 * Imports users' data, parse it, validate it,
	 * encrypts the password and stores 
	 * all users into the database.
	 * 
	 * @return Import status mentioning how many users 
	 * 		   were imported successfully and how many had 
	 *         encountered problem imorting
	 * 
	 * @throws UsersAlreadyExistException If database already has users
	 * @throws EmptyXmlFileException If the file from which data is being imported is empty
	 * @throws SQLException
	 */
	public String importUsers() throws UsersAlreadyExistException, EmptyUsersDataFileException, SQLException;

	/**
	 * Checks if database already has data.
	 * 
	 * @param connection to connect to database
	 * @return false if database already has data, else returns true
	 * @throws SQLException
	 */
	public boolean dbHasData(Connection connection) throws SQLException;
	
	/**
	 * Searches for users in database
	 * whose name starts with the
	 * given search string
	 * 
	 * @param searchString to search users by Name
	 * @return list of users whose name 
	 * 		   starts with the provided search string
	 * @throws SQLException
	 */
	public List<User> searchUserByName(String searchString) throws SQLException;
}
