package com.hsbc.meets.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.dao.FeedbackDao;
import com.hsbc.meets.factory.FeedBackFactory;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.service.FeedBackService;

/**
 * 
 * @author Muskan
 *
 */

public class FeedBackServiceImpl implements FeedBackService{
	static Logger logger = LoggerFactory.getLogger();

	@Override
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
	
	@Override
	public List<Meeting>getUpcomingMeeting(String emailInput) throws SQLException
	{
		List<Meeting> upComingMeeting = null;
		FeedbackDao feedBackDao = FeedBackFactory.getFeedBackDao();
		upComingMeeting = feedBackDao.getUpcomingMeeting(emailInput);  
        return upComingMeeting;
		
	}
	
	@Override
	public List<Meeting>getRecentMeeting(String emailInput) throws SQLException
	{
		List<Meeting> recentMeeting = null;
		FeedbackDao feedBackDao = FeedBackFactory.getFeedBackDao();
		recentMeeting = feedBackDao.getRecentMeetings(emailInput);  
        return recentMeeting;
		
	}


}
