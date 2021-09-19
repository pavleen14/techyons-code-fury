/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.exception;

public class MeetingRoomNameInvalidException extends Exception {
	
	@Override
	public String toString() {
		return "Meeting room name should be atleast 4 letters long and atmax 20 letters long.\nIt can only contain letters.\nNumbers and special characters in the name are not allowed.";
	}
}
