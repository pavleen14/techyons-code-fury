package com.hsbc.meets.service.impl;

import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.service.HomeService;

/**
 * Service class to handle business logic 
 * related to home screen
 * 
 * @author rishi
 *
 */

public class HomeServiceImpl implements HomeService {
	
	/**
	 * @return import status of XML
	 */
	public String importUsers() {
		HomeDao dao = HomeFactory.getHomeDao();
		String importStatus = "";		

		try {
			importStatus = dao.importUsers();	
		} catch (UsersAlreadyExistException e) {
			importStatus = "Users already imported";
			e.printStackTrace();
		} catch (EmptyXmlFileException e) {
			importStatus = "No data available to import";
			e.printStackTrace();
		} catch (JAXBException | SQLException e) {
			importStatus = "Error occured while importing users";
			e.printStackTrace();
		} 

		return importStatus;
	}
}