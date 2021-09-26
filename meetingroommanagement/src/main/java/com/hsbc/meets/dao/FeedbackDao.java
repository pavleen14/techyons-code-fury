package com.hsbc.meets.dao;

import java.sql.SQLException;
/**
 * Helps implement DAO classes which
 * intends add user feedback on database.
 * 
 * @author ajay
 *
 */


public interface FeedbackDao {

	/**
	 * This method inserts the feedback in database
	 * 
	 * @param rating
	 * @param comments
	 * @param userId
	 * @param meetingRoomId
	 * @throws SQLException
	 */

	public void addFeedback(int rating,String comments,int userId,int meetingRoomId)throws SQLException ;
	

	
}
