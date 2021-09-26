package com.hsbc.meets.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Query;
import com.hsbc.meets.util.Role;

/**
 * Implements Dao class to handle authentication.
 * 
 * @author Muskan
 *
 */
public class LoginJdbcDaoImpl implements LoginDao {
	static Logger logger = LoggerFactory.getLogger();
	
	@Override
	public User validate(String email, String encryptedPassword) throws SQLException, InvalidCredentialsException
	{
		Connection connection = Connectivity.getConnection();
		User user= null;

		CallableStatement statement = connection.prepareCall(Query.LOGIN_SELECT_USER_IF_AUTHENTICATED_SQL.getQuery());
		statement.setString(1,email);
		statement.setString(2,encryptedPassword);
		
		ResultSet resultSet = statement.executeQuery();
				
		if(resultSet.next())
		{
			user = new User();
			user.setUserId(resultSet.getInt("ID"));
			user.setName(resultSet.getString("Name"));
			user.setEmail(resultSet.getString("Email"));
			user.setPhone(resultSet.getString("Phone"));
			user.setCredits(resultSet.getInt("Credits"));
			user.setRole(Role.valueOf(resultSet.getString("Role")));
			user.setLastLogin(resultSet.getTimestamp("LastLogin"));
			
			updateLastLogin(resultSet.getInt("ID"), connection);
		}	
		else
		{
			throw new InvalidCredentialsException();
		}
		
		return user;
	}

	@Override
	public void updateLastLogin(int id, Connection connection) throws SQLException
	{
		CallableStatement statement = connection.prepareCall(Query.LOGIN_UPDATE_LAST_LOGIN_TO_CURRENT_TIMESTAMP.getQuery());
		statement.setInt(1, id);
		
		int rowsUpdated = statement.executeUpdate();
		System.out.println("sometimes not updating timestamp in db");
		if(rowsUpdated == 1)
		{
			logger.log(Level.INFO, "Logged in userId: " + id);
		}
		else
		{
			logger.log(Level.INFO, "Error updating last login for userId: " + id);
		}
	}
}
