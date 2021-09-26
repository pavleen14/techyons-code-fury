package com.hsbc.meets.exception;
/**
 * This classes is used when Meeting Room Amenities are Invalid with respect to its type.
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingRoomAmenitiesInvalidByMeetingTypeException extends Exception {
	@Override
	public String toString() {
		String message = "";
		message+="Meeting Room Amenities are Invalid with respect to its type.\n";
		message+="Meeting Room type Classroom training should have \t a whiteboard and a projector";
		message+="Meeting Room type Online training should have \t wifi and a projector";
		message+="Meeting Room type Conference call should have \t  conference call facility";
		message+="Meeting Room type business should have \t a Projector";
		return message;
	}
}
