package com.hsbc.meets.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.EmptyUsersDataFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.util.Converter;

/**
 * Implementing HomeService interface.
 * 
 * @author rishi
 *
 */

public class HomeServiceImpl implements HomeService {
	static Logger logger = LoggerFactory.getLogger();
	
	public String importUsers() {
		HomeDao dao = HomeFactory.getHomeDao();
		String importStatus = "";

		try {
			importStatus = dao.importUsers();	
		} catch (UsersAlreadyExistException e) {
			importStatus = "Users already imported";
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (EmptyUsersDataFileException e) {
			importStatus = "No data available to import";
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (SQLException e) {
			importStatus = "Error occured while importing users";
			logger.log(Level.SEVERE, e.getMessage(), e);
		} 

		return importStatus;
	}

	@Override
	public String searchUsersByName(String searchString) {
		HomeDao dao = HomeFactory.getHomeDao();
		StringBuffer matchedUsersJsonString = new StringBuffer("");
		
		try {
			List<User> matchedUsers = dao.searchUserByName(searchString);
			matchedUsersJsonString.append(Converter.objectToJsonString(matchedUsers));
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
				
		return matchedUsersJsonString.toString();
	}
}