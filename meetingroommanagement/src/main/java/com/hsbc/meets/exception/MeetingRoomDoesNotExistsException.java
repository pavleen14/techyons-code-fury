package com.hsbc.meets.exception;
/**
 * This exception is thrown when selected meeting room doesn't exists.
 * @author ShubhraBhuniaGhosh
 */
public class MeetingRoomDoesNotExistsException extends Exception {
	@Override
	public String toString() {
		return "Meeting room doesnot exist";
	}
}
