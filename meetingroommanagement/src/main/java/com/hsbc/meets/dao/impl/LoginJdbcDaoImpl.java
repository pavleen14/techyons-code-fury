package com.hsbc.meets.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Role;

/**
 * Implements Dao class to handle authentication.
 * 
 * @author Muskan
 *
 */
public class LoginJdbcDaoImpl implements LoginDao {
	
	private static final String SELECT_USER_IF_AUTHENTICATED_SQL = "SELECT ID, Name, Email, Phone, Credits, Role, LastLogin FROM users WHERE Email=? AND Password=?";
	private static final String UPDATE_LAST_LOGIN_TO_CURRENT_TIMESTAMP = "UPDATE users SET LastLogin=CURRENT_TIMESTAMP() WHERE ID=?";

	@Override
	public User validate(String email, String encryptedPassword) throws SQLException, InvalidCredentialsException
	{
		Connection connection = Connectivity.getConnection();
		User user= null;

		PreparedStatement statement = connection.prepareStatement(SELECT_USER_IF_AUTHENTICATED_SQL);
		statement.setString(1,email);
		statement.setString(2,encryptedPassword);
		
//		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		PreparedStatement statement = connection.prepareStatement(UPDATE_LAST_LOGIN_TO_CURRENT_TIMESTAMP);
		statement.setInt(1, id);
		
		int rowsUpdated = statement.executeUpdate();
		
		if(rowsUpdated == 1)
		{
			System.out.println("Last login updated!");
		}
		else
		{
			System.out.println("Error updating last login for userId: " + id);
		}
	}
}
