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

	@Override
	public String toString() {
		return "No data found in " + fileType + " file to add";
	}
}
