package com.hsbc.meets.exception;
/**
 * This exception is thrown when a duplicate meeting room is being created.
 * @author ShubhraBhuniaGhosh
 */
public class MeetingRoomAlreadyExistsException extends Exception {
	@Override
	public String toString() {
		return "This meeting room already exists in the database";
	}
}
