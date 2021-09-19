/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.entity;

import java.util.List;

public class MeetingRoom {
	private int meetingRoomId;
	private String meetingRoomName;
	private int seatingCapacity;
	private int rating;
	private List<String> amenities;
	private int creditsPerHour;
	private int noOfFeedbacks;
	
	public MeetingRoom(String meetingRoomName, int seatingCapacity, List<String> amenities,
			int creditsPerHour) {
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.amenities = amenities;
		this.creditsPerHour = creditsPerHour;
	}
	
	public MeetingRoom(String meetingRoomName, int seatingCapacity, int rating, List<String> amenities,
			int creditsPerHour, int noOfFeedbacks, boolean availability) {
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.rating = rating;
		this.amenities = amenities;
		this.creditsPerHour = creditsPerHour;
		this.noOfFeedbacks = noOfFeedbacks;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
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

	public int getMeetingRoomId() {
		return meetingRoomId;
	}
	
	
}
