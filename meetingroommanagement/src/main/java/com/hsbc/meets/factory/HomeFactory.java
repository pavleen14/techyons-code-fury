package com.hsbc.meets.factory;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.dao.impl.HomeJdbcDaoImpl;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.service.impl.HomeServiceImpl;

/**
 * Returns objects of appropriate implementations
 * of all interfaces related to home.
 * 
 * @author rishi
 *
 */
public class HomeFactory {
	
	/** 
	 * @return an object of DAO implementation
	 */
	public static HomeDao getHomeDao() {
		HomeDao dao = new HomeJdbcDaoImpl();
		return dao;
	}
	
	/** 
	 * @return an object of Service implementation
	 */
	public static HomeService getHomeService() {
		HomeService service = new HomeServiceImpl();
		return service;
	}
}
