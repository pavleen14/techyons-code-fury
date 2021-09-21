/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.exception;

public class MeetingRoomAmenitiesInvalidException extends Exception {
	@Override
	public String toString() {
		return "A meeting room must contain at least 2 amenities and at most 7 amenities.\nThe amenities provided must be among the 7 amenities listed";
	}
}