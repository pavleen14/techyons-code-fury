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
	HOME_CHECK_ROWS_IN_USERS_SQL("CALL sp_CheckRowsCountInUsers()"),
	HOME_INSERT_USERS_DATA_SQL("CALL sp_InsertIntoUsers(?,?,?,?,?,?)"),
	
	/**
	 * Login page queries
	 */
	LOGIN_SELECT_USER_IF_AUTHENTICATED_SQL("CALL sp_ValidateUsers(?,?)"),
	LOGIN_UPDATE_LAST_LOGIN_TO_CURRENT_TIMESTAMP("CALL sp_UpdateLastLogin(?)"),
	
	
	
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
