package com.hsbc.meets.exception;
/**
 * This is the exception class through which custom exception
 * is raised whenever Amenities added by the Admin are invalid. 
 * 
 * @author ShubhraBhuniaGhosh
 *
 *
 */

public class MeetingRoomAmenitiesInvalidException extends MeetingRoomInvalidException {
	
	public MeetingRoomAmenitiesInvalidException()
	{
		super();
	}
	
	public MeetingRoomAmenitiesInvalidException(String message)
	{
		super(message);
	}
	
	@Override
	public String toString() {
		return "You have added some invalided amenities";
	}
}
