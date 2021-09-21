package com.hsbc.meets.dao;

import java.sql.SQLException;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

public interface LoginDao {
	public User validate(String email,String encryptedPassword)throws SQLException,ClassNotFoundException, InvalidCredentialsException;
}
