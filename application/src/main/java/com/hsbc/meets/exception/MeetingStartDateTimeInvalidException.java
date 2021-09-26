package com.hsbc.meets.exception;
/**
 * This classes is used when Meeting Start Date Time is Invalid.
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingStartDateTimeInvalidException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Meeting start date and time should have more than 24 hours of difference from date and time of booking";
	}
}
