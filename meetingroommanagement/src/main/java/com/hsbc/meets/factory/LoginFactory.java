package com.hsbc.meets.factory;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.dao.impl.LoginJdbcDaoImpl;
import com.hsbc.meets.service.LoginService;
import com.hsbc.meets.service.impl.LoginServiceImpl;

/**
 * Returns objects of appropriate implementations
 * of all interfaces related to login.
 * 
 * @author Muskan
 *
 */
public class LoginFactory {
	/**
	 * This method is to get an object of dao class implementing login dao.
	 * @return
	 */
	public static LoginDao getLoginDao()
	{
		LoginDao dao = new LoginJdbcDaoImpl();
		return dao;
	}
    /**
     * This method is to get an object of service class implementing login service
     * @return
     */
	public static LoginService getLoginService()
	{
		LoginService service = new LoginServiceImpl();
		return service;

	}
}
