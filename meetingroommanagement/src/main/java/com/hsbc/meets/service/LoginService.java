package com.hsbc.meets.service;

import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

public interface LoginService {
	public User authentication(String email, String password) throws InvalidCredentialsException, ClassNotFoundException,SQLException;
}
