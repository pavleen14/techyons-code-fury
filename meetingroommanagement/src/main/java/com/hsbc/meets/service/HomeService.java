package com.hsbc.meets.service;

/**
 * Helps implement Service classes which
 * intends to handle the business logic of homepage.
 * 
 * @author rishi
 *
 */
public interface HomeService {
	/**
	 * Handles the respose to be sent back to
	 * the user based on different exceptions
	 * or successful import.
	 * 
	 * @return Import status message
	 */
	public String importUsers();
	
	/**
	 * Fetches the list of users and
	 * converts it into JSON string
	 * 
	 * @param searchString is a subpart of the name of a user
	 * @return List of users in string format
	 */
	public String searchUsersByName(String searchString);
}
