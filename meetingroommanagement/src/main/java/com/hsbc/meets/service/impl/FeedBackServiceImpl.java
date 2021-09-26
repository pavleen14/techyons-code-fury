package com.hsbc.meets.service.impl;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hsbc.meets.dao.FeedbackDao;
import com.hsbc.meets.factory.FeedBackFactory;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.service.FeedBackService;

public class FeedBackServiceImpl implements FeedBackService{
	static Logger logger = LoggerFactory.getLogger();

	public String addFeedBack(int roomname,int id,int rating,String comment) 
	{
		String feedBackStatus = null;
        try
		{
			FeedbackDao feedBackDao = FeedBackFactory.getFeedBackDao();
			feedBackDao.addFeedback(rating, comment, id, roomname);
		}
		catch (SQLException  e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			feedBackStatus =  "Something went wrong.\nTry again later.";
		}  

		return  feedBackStatus;
	}


}
