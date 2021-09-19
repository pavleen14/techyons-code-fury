package com.hsbc.meets.factory;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.dao.impl.HomeDaoImpl;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.service.impl.HomeServiceImpl;

public class HomeFactory {
	public static HomeDao getHomeDao() {
		HomeDaoImpl dao = new HomeDaoImpl();
		return dao;
	}
	
	public static HomeService getHomeService() {
		HomeServiceImpl service = new HomeServiceImpl();
		return service;
	}
}
