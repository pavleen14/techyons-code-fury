package com.hsbc.meets.exception;

/**
 * Generated when user enters invalid credentials.
 * 
 * @author Muskan
 *
 */
public class InvalidCredentialsException extends Exception {
	
	/**
	 * @return the error message
	 */
	public String getMessage() {
		return this.toString();
	}
	
	@Override
	public String toString()
	{
		return "Invalid Credentials";
	}

}
