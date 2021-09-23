package com.hsbc.meets.dao.impl;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import com.hsbc.meets.dao.HomeDao;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.EmptyUsersDataFileException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.util.Connectivity;
import com.hsbc.meets.util.Encryption;
import com.hsbc.meets.util.Query;
import com.hsbc.meets.util.Validator;
import com.hsbc.meets.util.XmlParser;

/**
 * Connects with MySQL database using
 * JDBC Driver to handle the data of homepage.
 * 
 * @author rishi
 *
 */
public class HomeJdbcDaoImpl implements HomeDao {
	private static final String XML_FILE_PATH = "src/main/webapp/resources/users.xml";
	static Logger logger = LoggerFactory.getLogger();

	/**
	 * Fetches all users from XML file to store into database.
	 */
	@Override
	public String importUsers() throws UsersAlreadyExistException, EmptyUsersDataFileException, SQLException {
		Connection connection = Connectivity.getConnection();
		CallableStatement statement = null;
		String importStatus = "";

		try {
			if(dbHasData(connection)) {
				File xmlFile = new File(XML_FILE_PATH);
				List<User> users = XmlParser.toUsers(xmlFile);

				if(users != null) {
					List<User> usersNotImported = new ArrayList<User>();
					int records = 0;
					connection.setAutoCommit(false);

					statement = connection.prepareCall(Query.HOME_INSERT_USERS_DATA_SQL.getQuery());

					Validator validator = new Validator();

					for(User user: users ) {
						if(validator.validateUser(user)) {
							statement.setString(1, user.getName());
							statement.setString(2, user.getEmail());
							statement.setString(3, user.getPhone());
							statement.setInt(4, user.getCredits());
							statement.setString(5, user.getRole().toString());
							statement.setString(6, Encryption.md5(user.getPassword()));

							statement.addBatch();
							records++;

							// It's executed every 1000 items because some JDBC drivers 
							// and/or DBs may have a limitation on batch length.
							if (records % 1000 == 0 || records == users.size() - usersNotImported.size()) {
								statement.executeBatch();
								connection.commit();
							}
						} else {
							usersNotImported.add(user);
						}
					}
					if(usersNotImported.size() > 0) {
						logger.log(Level.INFO, "Could not import: "+usersNotImported.size()+" user(s) due to incorrect data format.");
						for(User user: usersNotImported) {
							logger.log(Level.INFO, user.toString());
						}
						importStatus = "Successfully imported "+(users.size() - usersNotImported.size())+" uesrs.\nCould not import "+usersNotImported.size()+" users due to data inconsistency.";
					} else {
						importStatus = "Successfully imported "+(users.size())+" uesrs.";
					}
				} else {
					throw new EmptyUsersDataFileException("XML");
				}
			} else {
				throw new UsersAlreadyExistException();
			}

		} catch (JAXBException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if(statement != null)
					statement.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		return importStatus;
	}

	@Override
	public boolean dbHasData(Connection connection) throws SQLException {
		CallableStatement statement = connection.prepareCall(Query.HOME_CHECK_ROWS_IN_USERS_SQL.getQuery());

		ResultSet rs = statement.executeQuery();

		return rs.next() && rs.getInt(1) == 0;
	}

	@Override
	public List<User> searchUserByName(String searchString) throws SQLException {
		List<User> matchedUsers = new ArrayList<>();
		User user = null;
		Connection connection = Connectivity.getConnection();
		
		CallableStatement statement = connection.prepareCall(Query.HOME_SELECT_USERS_BY_NAME_SQL.getQuery());
		statement.setString(1, searchString+"%");
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next())
		{
			user = new User();
			user.setUserId(resultSet.getInt("ID"));
			user.setName(resultSet.getString("Name"));
			user.setEmail(resultSet.getString("Email"));
			matchedUsers.add(user);
		}
		
		return matchedUsers;
	}

}