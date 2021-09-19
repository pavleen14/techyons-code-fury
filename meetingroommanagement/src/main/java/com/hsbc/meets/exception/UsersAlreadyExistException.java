package com.hsbc.meets.exception;

public class UsersAlreadyExistException extends Exception {
	
	@Override
	public String toString() {
		return "Database already has users";
	}
}
