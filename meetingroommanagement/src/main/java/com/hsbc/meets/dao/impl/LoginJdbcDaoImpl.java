package com.hsbc.meets.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.dao.LoginDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Role;

public class LoginJdbcDaoImpl implements LoginDao{
	@Override
	public User validate(String email,String encryptedPassword)throws SQLException, InvalidCredentialsException
	{
		Connection connection = Connectivity.getConnection();
		String sql = "Select ID,Name,Email,Phone,Credits,Role,LastLogin from users where Email=? and Password=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,email);
		statement.setString(2,encryptedPassword);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
			user.setLastLogin(result.getTimestamp("LastLogin"));
            updateLastLogin(result.getInt("ID"),connection);
		}	
		else
		{
			throw new InvalidCredentialsException();
		}


		return user;
	}
	
	@Override
	public void updateLastLogin(int id,Connection con) throws SQLException
	{
		String sql_query = "UPDATE users set LastLogin=CURRENT_TIMESTAMP() where Id=?";
        PreparedStatement statement = con.prepareStatement(sql_query);
		statement.setInt(1, id);
		int count = statement.executeUpdate();
		if(count == 1)
		{
			System.out.println("Last login updated!!");
		}
		else
		{
			System.out.println("Last login update failed for userId:" + id);
		}

	}


}
