package com.hsbc.meets.dao;

import com.hsbc.meets.exception.UsersAlreadyExistException;

public interface HomeDao {
	public boolean importUsers() throws UsersAlreadyExistException;
}
