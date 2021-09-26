package com.hsbc.meets.exception;
/**
 * This classes is used when Meeting Title is Invalid.
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingTitleInvalidException extends Exception {
	@Override
	public String toString() {
		return "Meeting title should be at least 4 letters long and at max 20 letters long.\nIt can only contain letters.\nNumbers and special characters in the name are not allowed.\nMeeting title must be unique.";
	}
}
