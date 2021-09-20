package com.hsbc.meets.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.util.UsersDocument;;

abstract public class XmlParser {
	public static List<User> toUsers(File xmlFile) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(UsersDocument.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		return ((UsersDocument) unmarshaller.unmarshal(xmlFile)).getUsers();
	}
}
