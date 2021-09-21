package com.hsbc.meets.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;

public interface HomeDao {
	public String importUsers() throws UsersAlreadyExistException, JAXBException, EmptyXmlFileException, SQLException;
	public boolean dbHasData(Connection connection) throws SQLException;
}
