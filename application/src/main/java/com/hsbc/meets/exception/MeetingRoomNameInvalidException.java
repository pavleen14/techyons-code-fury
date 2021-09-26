package com.hsbc.meets.exception;
/**
 * This is the exception class through which custom exception
 * is raised whenever the length of the meeting room name is not
 * as per the specifications  
 * 
 * @author ShubhraBhuniaGhosh
 *
 *
 */
public class MeetingRoomNameInvalidException extends MeetingRoomInvalidException{
	
	public MeetingRoomNameInvalidException() {
		super();
	}

	public MeetingRoomNameInvalidException (String message) {
		super(message);
	}
	
	@Override
		public String toString() {
			return "The meeting room name is invalid";
		}

}
