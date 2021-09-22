package com.hsbc.meets.entity;

import java.util.List;
/**
 * @author ShubhraBhuniaGhosh
 */
public class MeetingRoom {
	private int meetingRoomId;
	private String meetingRoomName;
	private int seatingCapacity;
	private List<String> amenities;
	private int creditsPerHour;
	private int rating;
	private int noOfFeedbacks;
	
	public MeetingRoom(String meetingRoomName, int seatingCapacity, List<String> amenities) {
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.amenities = amenities;
	}
	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities,
			int creditsPerHour, int rating, int noOfFeedbacks) {
		this.meetingRoomId = meetingRoomId;
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.amenities = amenities;
		this.creditsPerHour = creditsPerHour;
		this.rating = rating;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
