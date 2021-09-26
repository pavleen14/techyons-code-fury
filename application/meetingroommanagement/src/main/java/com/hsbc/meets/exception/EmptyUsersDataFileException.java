package com.hsbc.meets.exception;

/**
 * Returned when the XML file used to 
 * 
 * @author rishi
 *
 */
public class EmptyUsersDataFileException extends Exception {
	
	String fileType;
		
	/**
	 * @param fileType of empty file used to import data
	 */
	public EmptyUsersDataFileException(String fileType) {
		this.fileType = fileType;
	}
	
	/**
	 * @return the error message
	 */
	public String getMessage() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return this.toString();
	}
}
