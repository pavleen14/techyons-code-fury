package com.hsbc.meets.exception;
/**
 * This Exception is thrown when Meeting room name already exists in the database in the respected table.
 * @author ShubhraBhuniaGhosh
 */
public class MeetingRoomNameAlreadyExistException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meeting RoomName Already Exist Exception";
	}
}
