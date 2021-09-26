package com.hsbc.meets.exception;

/**
 * This is the exception class through which custom exception
 * is raised whenever Meeting Room with same id exists. 
 * 
 * @author PavleenKaur
 *
 *
 */

public class MeetingRoomAlreadyExistsException extends Exception {

	public MeetingRoomAlreadyExistsException() {
		super();
	}

	public MeetingRoomAlreadyExistsException(String message) {
		super(message);
	}

}
