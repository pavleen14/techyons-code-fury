package com.hsbc.meets.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.util.UsersDocument;;

/**
 * Parses XML file.
 * 
 * @author rishi
 *
 */
abstract public class XmlParser {
	
	/**
	 * Parses XML file and stores all the users' data
	 * into list of User objects.
	 * 
	 * @param xmlFile containing all the users' data
	 * @return list of User objects
	 * @throws JAXBException
	 */
	public static List<User> toUsers(File xmlFile) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(UsersDocument.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		return ((UsersDocument) unmarshaller.unmarshal(xmlFile)).getUsers();
	}
}
