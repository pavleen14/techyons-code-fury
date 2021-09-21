package com.hsbc.meets.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.EmptyXmlFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Encryption;
import com.hsbc.meets.util.Validator;
import com.hsbc.meets.util.XmlParser;

public class HomeJdbcDaoImpl implements HomeDao {

	private static final String CHECK_ROWS_IN_USERS_SQL = "SELECT COUNT(*) FROM users";
	private static final String INSERT_USERS_DATA_SQL = "INSERT INTO users (ID, Name, Email, Phone, Credits, Role, Password) VALUES(?,?,?,?,?,?,?)";
	private static final String XML_FILE_PATH = "src/main/webapp/resources/users.xml";
	
	@Override
	public String importUsers() throws UsersAlreadyExistException, JAXBException, EmptyXmlFileException, SQLException {
		Connection connection = Connectivity.getConnection();
		PreparedStatement statement = null;
		String importStatus = "";
		
		try {
			if(dbHasData(connection)) {
				File xmlFile = new File(XML_FILE_PATH);
				List<User> users = XmlParser.toUsers(xmlFile);

				if(users != null) {
					List<User> usersNotImported = new ArrayList<User>();
					int records = 0;

					statement = connection.prepareStatement(INSERT_USERS_DATA_SQL);
					connection.setAutoCommit(false);

					Validator validator = new Validator();

					for(User user: users ) {
						if(validator.validateUser(user)) {
							statement.setInt(1, user.getUserId());
							statement.setString(2, user.getName());
							statement.setString(3, user.getEmail());
							statement.setString(4, user.getPhone());
							statement.setInt(5, user.getCredits());
							statement.setString(6, user.getRole().toString());
							statement.setString(7, Encryption.md5(user.getPassword()));

							statement.addBatch();
							records++;

							// It's executed every 1000 items because some JDBC drivers 
							// and/or DBs may have a limitation on batch length.
							if (records % 1000 == 0 || records == users.size()) {
								statement.executeBatch();
								connection.commit();
							}
						} else {
							usersNotImported.add(user);
						}
					}
					if(usersNotImported.size() > 0) {
						System.out.println("Could not import: "+usersNotImported.size()+" users due to incorrect data format.");
						for(User user: usersNotImported) {
							System.out.println(user);
						}
						importStatus = "Successfully imported "+(users.size() - usersNotImported.size())+" uesrs.\nCould not import "+usersNotImported.size()+" users due to data inconsistency.";
					}
				} else {
					throw new EmptyXmlFileException();
				}
			} else {
				throw new UsersAlreadyExistException();
			}

		} finally {
			try {
				if(statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return importStatus;
	}

	@Override
	public boolean dbHasData(Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(CHECK_ROWS_IN_USERS_SQL);

		ResultSet rs = statement.executeQuery();

		return rs.next() && rs.getInt(1) == 0;
	}
}