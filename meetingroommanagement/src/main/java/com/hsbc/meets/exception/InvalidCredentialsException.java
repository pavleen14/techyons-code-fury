package com.hsbc.meets.exception;

/**
 * Generates when user enters invalid credentials .
 * @author Muskan
 *
 */
public class InvalidCredentialsException extends Exception {
	@Override
	public String toString()
	{
		return "Invalid Credentials";
	}

}
