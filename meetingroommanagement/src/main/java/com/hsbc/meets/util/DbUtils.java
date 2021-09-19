/**
 * The Database connection utility
 * 
 * @author pavleen 
 * @since 0.0.1
 */
package com.hsbc.meets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	static Connection conn = null;

	public static Connection getDBConnection() {

		// specify the name of database here

		String url = "jdbc:mysql://localhost:3306/";

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// add user-name & password here from the properties file
			conn = DriverManager.getConnection(url, "", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
