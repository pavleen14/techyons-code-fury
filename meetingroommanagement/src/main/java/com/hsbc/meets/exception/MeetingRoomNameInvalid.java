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
public class MeetingRoomNameInvalid extends Exception{

	public MeetingRoomNameInvalid() {
		super();
	}

	public MeetingRoomNameInvalid (String message) {
		super(message);
	}

}
