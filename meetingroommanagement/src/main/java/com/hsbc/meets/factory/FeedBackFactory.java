package com.hsbc.meets.factory;

import com.hsbc.meets.dao.FeedbackDao;
import com.hsbc.meets.dao.impl.FeedbackJDBCDaoImpl;
import com.hsbc.meets.service.FeedBackService;
import com.hsbc.meets.service.impl.FeedBackServiceImpl;



public class FeedBackFactory {
	
	/** 
	 * @return an object of DAO implementation
	 */
	public static FeedbackDao getFeedBackDao() {
		FeedbackDao dao = new FeedbackJDBCDaoImpl();
		return dao;
	}
	
	/** 
	 * @return an object of Service implementation
	 */
	public static FeedBackService getFeedBackService() {
		FeedBackService service = new FeedBackServiceImpl();
		return service;
	}
}



