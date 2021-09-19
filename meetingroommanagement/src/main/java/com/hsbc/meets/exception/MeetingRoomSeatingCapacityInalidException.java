package com.hsbc.meets.exception;

public class MeetingRoomSeatingCapacityInalidException extends Exception {
	@Override
	public String toString() {
		return "Seating Capacity should be greater than or equal to 6 and less than or equal to 250.";
	}
}
