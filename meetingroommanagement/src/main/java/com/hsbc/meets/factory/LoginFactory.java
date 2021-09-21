package com.hsbc.meets.factory;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.dao.impl.LoginJdbcDaoImpl;
import com.hsbc.meets.service.LoginService;
import com.hsbc.meets.service.impl.LoginServiceImpl;

public class LoginFactory {
	public static LoginDao getLoginDao()
	{
		LoginDao dao = new LoginJdbcDaoImpl();
		return dao;
	}

	public static LoginService getLoginService()
	{
		LoginService service = new LoginServiceImpl();
		return service;

	}
}
