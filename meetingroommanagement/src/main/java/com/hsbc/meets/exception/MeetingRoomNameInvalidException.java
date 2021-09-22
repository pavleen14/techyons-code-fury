package com.hsbc.meets.exception;
/**
 * This Exception is thrown when meeting room name already exists.
 * @author ShubhraBhuniaGhosh
 */
public class MeetingRoomNameInvalidException extends Exception {
	
	@Override
	public String toString() {
		return "Meeting room name should be at least 4 letters long and at max 20 letters long.\nIt can only contain letters.\nNumbers and special characters in the name are not allowed.";
	}
}
