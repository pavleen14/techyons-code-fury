package com.hsbc.meets.dao.impl;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.util.XmlParser;

public class HomeJdbcDaoImpl implements HomeDao {

	@Override
	public void importUsers(File xmlFile) throws UsersAlreadyExistException, JAXBException, EmptyXmlFileException {
		// TODO first check if DB already has data:
		//			if yes, then  UsersAlreadyExistException()
		//			else below code

		List<User> users = XmlParser.toUsers(xmlFile);

		if(users != null) {
			for(User user: users ) {
				System.out.println(user);
			}

			// TODO prepare statement
			// TODO insert into DB

		} else {
			throw new EmptyXmlFileException();
		}
	}
}