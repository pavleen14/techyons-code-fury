package com.hsbc.meets.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

import com.hsbc.meets.exception.InvalidPropFileException;
import com.hsbc.meets.factory.LoggerFactory;

/**
 * Establishes connection with the database
 * 
 * @author rishi
 *
 */
public class Connectivity {
	public static Connection connection = null;
	public static SQLConnectionCredentials credentials = null;
	static Logger logger = LoggerFactory.getLogger();
	
	/**
	 * Creates connection if doesn't already exists
	 * 
	 * @return Connection object
	 */
	public static Connection getConnection() {
		try {
			if(connection == null) {
				credentials = SQLConnectionCredentials.readCredentials();
				Class.forName(credentials.getDriverName());
				connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());
				logger.log(Level.INFO, "Connection extablished to DB.");
			}
		} catch (ClassNotFoundException | SQLException | InvalidPropFileException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return connection;
	}

	/**
	 * Closes the connection.
	 */
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
				logger.log(Level.INFO, "Connection closed.");
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}
}
