package com.hsbc.meets.dao.impl;
import java.sql.*;

import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Role;
import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;

public class LoginJdbcDaoImpl implements LoginDao{
	public User validate(String email,String encryptedPassword)throws SQLException, InvalidCredentialsException
	{
		Connection connection = Connectivity.getConnection();
		String sql = "Select ID,Name,Email,Phone,Credits,Role,LastLogin from users where Email=? and Password=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,email);
		statement.setString(2,encryptedPassword);
		
		ResultSet result = statement.executeQuery();
		User user= null;
		if(result.next())
		{
			user = new User();
			user.setUserId(result.getInt("ID"));
			user.setName(result.getString("Name"));
		    user.setEmail(result.getString("Email"));
			user.setPhone(result.getString("Phone"));
		    user.setCredits(result.getInt("Credits"));
			user.setRole(Role.valueOf(result.getString("Role").toUpperCase()));
			//user.getLastLogin(new Date(result.getTimestamp(7).getTime()));
			
			//update last login = current time stamp where ID = result.getInt("ID")
		}	
		else
		{
			throw new InvalidCredentialsException();
		}
		
	    Connectivity.closeConnection();
	    return user;
		
		
		
	}
	

}
