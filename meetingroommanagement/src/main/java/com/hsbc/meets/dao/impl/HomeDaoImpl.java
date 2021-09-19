package com.hsbc.meets.dao.impl;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.exception.UsersAlreadyExistException;

public class HomeDaoImpl implements HomeDao {

	@Override
	public boolean importUsers() throws UsersAlreadyExistException {
		return false;
		// TODO fetch XML file from server, parse it, store into DB
	}

}
