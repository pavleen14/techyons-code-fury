package com.hsbc.meets.service.impl;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.service.HomeService;

public class HomeServiceImpl implements HomeService {
	public boolean importUsers() {
		HomeDao dao = HomeFactory.getHomeDao();
		try {
			dao.importUsers();
			return true;
		} catch (UsersAlreadyExistException e) {
			e.printStackTrace();
			return false;
		}
	}
}