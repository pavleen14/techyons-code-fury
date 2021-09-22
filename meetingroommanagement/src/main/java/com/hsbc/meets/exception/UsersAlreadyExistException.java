package com.hsbc.meets.exception;

/**
 * Occured when database already has data,
 * while importing users.
 * 
 * @author rishi
 *
 */
public class UsersAlreadyExistException extends Exception {
	
	@Override
	public String toString() {
		return "Database already has users";
	}
}
