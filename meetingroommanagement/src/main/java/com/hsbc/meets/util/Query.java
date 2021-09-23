package com.hsbc.meets.util;

/**
 * Provides all SQL queries
 * 
 * @author rishi
 *
 */
public enum Query {
	/**
	 * Home page queries
	 */
	HOME_SELECT_USERS_BY_NAME_SQL("SELECT ID, Name, Email FROM tbl_users WHERE Name LIKE ?"),
	HOME_CHECK_ROWS_IN_USERS_SQL("SELECT COUNT(*) FROM tbl_users"),
	HOME_INSERT_USERS_DATA_SQL("INSERT INTO tbl_users (Name, Email, Phone, Credits, Role, Password) VALUES(?,?,?,?,?,?)"),
	
	/**
	 * Login page queries
	 */
	LOGIN_SELECT_USER_IF_AUTHENTICATED_SQL("SELECT ID, Name, Email, Phone, Credits, Role, LastLogin FROM tbl_users WHERE Email=? AND Password=?"),
	LOGIN_UPDATE_LAST_LOGIN_TO_CURRENT_TIMESTAMP("UPDATE tbl_users SET LastLogin=CURRENT_TIMESTAMP() WHERE ID=?"),
	
	
	
	// Add queries above this line
	;
	private final String query;

	Query(String query) {
		this.query = query;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
}
