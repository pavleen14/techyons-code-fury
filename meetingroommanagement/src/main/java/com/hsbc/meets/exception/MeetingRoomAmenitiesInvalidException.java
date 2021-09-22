package com.hsbc.meets.exception;
/**
 * This is the exception class through which custom exception
 * is raised whenever Amenities added by the Admin are invalid. 
 * 
 * @author ShubhraBhuniaGhosh
 *
 *
 */

public class MeetingRoomAmenitiesInvalidException extends Exception {
	
	public MeetingRoomAmenitiesInvalidException()
	{
		super();
		
	}
	
	public MeetingRoomAmenitiesInvalidException(String message)
	{
		super(message);
		
	}
}
