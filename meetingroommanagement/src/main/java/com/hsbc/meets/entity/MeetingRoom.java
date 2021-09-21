/**
 * This entity sub-package stores the classes such as MeetingRoom which
 * represents the logical components of the application. 
 * 
 * @author pavleen 
 * @since 0.0.1
 */
package com.hsbc.meets.entity;

import java.util.Arrays;

public class MeetingRoom {

	int meetingRoomId;
	String meetingRoomName;
	int seatingCapacity;
	float rating;
	String[] Amenities;
	int creditsPerHour;
	int noOfFeedbacks;

	// constructors

	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, float rating, String[] amenities,
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
	
	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, String[] amenities,
			int creditsPerHour) {
		super();
		this.meetingRoomId = meetingRoomId;
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.rating = 0;
		Amenities = amenities;
		this.creditsPerHour = creditsPerHour;
		this.noOfFeedbacks =0;
		}


	// getters & setters

	public int getMeetingRoomId() {
		return meetingRoomId;
	}

	public void setMeetingRoomId(int meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}
	
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
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

	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomId=" + meetingRoomId + ", meetingRoomName=" + meetingRoomName
				+ ", seatingCapacity=" + seatingCapacity + ", rating=" + rating + ", Amenities="
				+ Arrays.toString(Amenities) + ", creditsPerHour=" + creditsPerHour + ", noOfFeedbacks=" + noOfFeedbacks
				+ "]";
	}

}
