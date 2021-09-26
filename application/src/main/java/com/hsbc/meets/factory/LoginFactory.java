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
	 * @return object of a dao class implementing LoginDao.
	 */
	public static LoginDao getLoginDao()
	{
		LoginDao dao = new LoginJdbcDaoImpl();
		return dao;
	}
	
	
    /**
     * @return object of a service class implementing LoginService.
     */
	public static LoginService getLoginService()
	{
		LoginService service = new LoginServiceImpl();
		return service;
	}
}
