package com.hsbc.meets.exception;
/**
 * This classes is used when manager booking the meeting does not have enough credits.
 * @author ShubhraBhuniaGhosh
 */
public class NotEnoughCreditsException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cradits Insufficient";
	}
}
