package com.hsbc.meets.exception;
/**
 * This classes is used when Meeting Duration is Invalid. It prints a message 'Duration of the meeting 
 * should be atleast  * 30 min long and atmost 540 min long'.
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingDurationInvalidException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Duration of the meeting should be atleast 30 min long and atmost 540 min long.";
	}
}
