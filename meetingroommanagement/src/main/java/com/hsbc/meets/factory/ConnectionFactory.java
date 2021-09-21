package com.hsbc.meets.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		// add the path to the properties file. 
		InputStream in = new FileInputStream("D:/eclipse-workspace/techyons-code-fury/meetingroommanagement/jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	
	static Connection conn = null;
	public static Connection getDBConnection() {
	
		try {
		Properties prop = loadPropertiesFile();

		String driverClass = prop.getProperty("dname");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Class.forName(driverClass);

		
//		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		conn = DriverManager.getConnection(url, username, password);
		

		if (conn != null) {
			System.out.println("connection created successfully using properties file");
		}

		else {
			System.out.println(" unable to create connection");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


}
