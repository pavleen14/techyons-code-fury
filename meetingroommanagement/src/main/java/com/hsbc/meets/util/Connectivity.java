package com.hsbc.meets.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import com.hsbc.meets.exception.InvalidPropFileException;


public class Connectivity {
	public static Connection connection = null;
	public static SQLConnectionCredentials credentials = null;
	
	public static Connection getConnection() {
		try {
			if(connection == null) {
				credentials = SQLConnectionCredentials.readCredentials();
				Class.forName(credentials.getDriverName());
				connection = DriverManager.getConnection(credentials.getUrl(), credentials.getUsername(), credentials.getPassword());
				System.out.println("Connection extablished to DB.");
			}
		} catch (ClassNotFoundException | SQLException | InvalidPropFileException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
				System.out.println("Connection closed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
