/**
 * 
 */
package com.hsbc.meets.exception;

/**
 * @author alan
 *
 */
public class MeetingRoomInvalidException extends Exception {

	public MeetingRoomInvalidException() {
		
	}
	
	public MeetingRoomInvalidException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "Meeting room attributes are invalid";
	}
}
