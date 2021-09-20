package com.hsbc.meets.dao;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;

public interface HomeDao {
	public void importUsers(File xmlFile) throws UsersAlreadyExistException, JAXBException, EmptyXmlFileException;
}
