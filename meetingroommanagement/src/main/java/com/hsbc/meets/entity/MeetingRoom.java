/**
 * This entity sub-package stores the classes such as MeetingRoom which
 * represents the logical components of the application. 
 * 
 * @author pavleen 
 * @since 0.0.1
 */
package com.hsbc.meets.entity;

import java.util.Arrays;
import java.util.List;

public class MeetingRoom {

	private int meetingRoomId;
	private String meetingRoomName;
	private int seatingCapacity;
	private int rating;
	private List<String> amenities;
	private int creditsPerHour;
	private int noOfFeedbacks;

	// constructors

	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, int rating, String[] amenities,
			int creditsPerHour, int noOfFeedbacks) {
		super();
		this.meetingRoomId = meetingRoomId;
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
		Amenities = amenities;
		this.creditsPerHour = creditsPerHour;
		this.noOfFeedbacks = noOfFeedbacks;
	}

	// getters & setters

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String[] getAmenities() {
		return Amenities;
	}

	public void setAmenities(String[] amenities) {
		Amenities = amenities;
	}

	public int getCreditsPerHour() {
		return creditsPerHour;
	}

	public void setCreditsPerHour(int creditsPerHour) {
		this.creditsPerHour = creditsPerHour;
	}

	public int getNoOfFeedbacks() {
		return noOfFeedbacks;
	}

	public void setNoOfFeedbacks(int noOfFeedbacks) {
		this.noOfFeedbacks = noOfFeedbacks;
	}

	// toString()

	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomId=" + meetingRoomId + ", meetingRoomName=" + meetingRoomName
				+ ", seatingCapacity=" + seatingCapacity + ", rating=" + rating + ", Amenities="
				+ Arrays.toString(Amenities) + ", creditsPerHour=" + creditsPerHour + ", noOfFeedbacks=" + noOfFeedbacks
				+ "]";
	}

}
