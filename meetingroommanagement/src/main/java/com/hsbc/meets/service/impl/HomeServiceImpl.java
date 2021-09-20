package com.hsbc.meets.service.impl;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.service.HomeService;

public class HomeServiceImpl implements HomeService {

	public String importUsers() {
		
		// TODO store this as servlet config or env variable
		final String XML_FILE_PATH = "D:\\HSBC\\Training\\Web\\techyons-code-fury\\meetingroommanagement\\src\\main\\webapp\\resources\\users.xml";
		HomeDao dao = HomeFactory.getHomeDao();
		String importStatus = "";
		
		File xmlFile = new File(XML_FILE_PATH);

		try {
			dao.importUsers(xmlFile);
			importStatus = "Users successfully imported"; 
		} catch (UsersAlreadyExistException e) {
			importStatus = "Users already imported";
			e.printStackTrace();
		} catch (JAXBException e) {
			importStatus = "Error occured while importing users";
			e.printStackTrace();
		} catch (EmptyXmlFileException e) {
			importStatus = "No data available to import";
			e.printStackTrace();
		}
		
		return importStatus;
	}
}