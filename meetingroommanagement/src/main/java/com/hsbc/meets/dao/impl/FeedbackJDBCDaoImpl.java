package com.hsbc.meets.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import com.hsbc.meets.dao.FeedbackDao;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Query;
import java.sql.SQLException;

/**
 * Implements Dao class to Add feedback.
 * 
 * @author Ajay
 *
 */
public class FeedbackJDBCDaoImpl implements FeedbackDao {
	
	private static final String ADD_FEEDBACK_BY_USERID_SQL = "call sp_InsertFeedback(?,?,?,?)";
	@Override
	public void addFeedback(int rating,String comments,int userId,int meetingRoomId) throws SQLException{
		Connection connection = Connectivity.getConnection();
		CallableStatement statement = connection.prepareCall(ADD_FEEDBACK_BY_USERID_SQL);
		statement.setInt(1,rating);
		statement.setString(2,comments);
		statement.setInt(3,userId);
		statement.setInt(4,meetingRoomId);
		statement.execute();
	}
	
}
