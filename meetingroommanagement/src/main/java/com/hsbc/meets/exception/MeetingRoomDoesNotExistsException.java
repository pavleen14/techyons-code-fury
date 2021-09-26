package com.hsbc.meets.exception;
/**
 * This is the exception class through which custom exception
 * is raised when admin tries to access the meeting room which does not exist. 
 * 
 * @author PavleenKaur
 *
 *
 */

public class MeetingRoomDoesNotExistsException extends Exception {

	public MeetingRoomDoesNotExistsException() {
		super();
	}

	public MeetingRoomDoesNotExistsException(String message) {
		super(message);
	}

}
