package com.hsbc.meets.exception;
/**
 * This is the exception class through which custom exception
 * is raised when the invalid seating capacity has been entered by the admin
 * for the meeting room.
 * 
 * @author ShubhraBhuniaGhosh
 *
 *
 */
public class MeetingRoomSeatingCapacityInvalidException extends Exception {
	
	public MeetingRoomSeatingCapacityInvalidException() {
		super();
	}
	
	public MeetingRoomSeatingCapacityInvalidException(String message) {
		super(message);
	}


}
