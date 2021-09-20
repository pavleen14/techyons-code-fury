/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.exception;

public class MeetingRoomDoesNotExistsException extends Exception {
	@Override
	public String toString() {
		return "Meeting room doesnot exist";
	}
}
