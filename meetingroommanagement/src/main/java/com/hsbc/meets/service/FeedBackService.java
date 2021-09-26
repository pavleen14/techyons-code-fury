package com.hsbc.meets.service;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.meets.entity.Meeting;

/**
 *  Helps implement Service class which
 * intends to handle the business 
 * logic of submitting feedback.
 * @author Muskan	
 *
 */
public interface FeedBackService {

	/**
	 * 	
	 * @param roomname
	 * @param id
	 * @param rating
	 * @param comment
	 * @return feedBackStatus
	 */
	public String addFeedBack(int roomname,int id,int rating,String comment);
	/**
	 * 
	 * @param emailInput
	 * @return
	 * @throws SQLException 
	 */
	public List<Meeting>getUpcomingMeeting(String emailInput) throws SQLException;
	/**
	 * 
	 * @param emailInput
	 * @return
	 * @throws SQLException
	 */
	public List<Meeting>getRecentMeeting(String emailInput) throws SQLException;
}
