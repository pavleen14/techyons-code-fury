package com.hsbc.meets.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * The is the entity class for the Meeting Room 
 * which is the basic logical component
 * of the application. 
 * 
 * @author PavleenKaur
 * @author ShubhraBhuniaGhosh
 *
 */

public class MeetingRoom {

	private int meetingRoomId;
	private String meetingRoomName;
	private int seatingCapacity;
	private float rating;
	private List<String> amenities;
	private float creditsPerHour;
	private int noOfFeedbacks;
	
	
	public MeetingRoom(String meetingRoomName, int seatingCapacity, List<String> amenities) {
		this.meetingRoomName = meetingRoomName;
		this.seatingCapacity = seatingCapacity;
		this.amenities = amenities;
		this.creditsPerHour = 0;
		this.rating = 0f;
		this.noOfFeedbacks = 0;
	}
	
	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities) {
		this(meetingRoomName, seatingCapacity, amenities);
		this.meetingRoomId = meetingRoomId;
		this.rating = 0f;
		this.creditsPerHour = 0;
		this.noOfFeedbacks = 0;
	}
	
	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, float rating, float creditsPerHour) {
		this(meetingRoomId, meetingRoomName, seatingCapacity, new ArrayList<String>());
		this.rating = rating;
		this.creditsPerHour = creditsPerHour;
	}
	
	public MeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities, float creditsPerHour, float rating, int noOfFeedbacks) {
		this(meetingRoomId, meetingRoomName, seatingCapacity, amenities);
		this.rating = rating;
		this.creditsPerHour = creditsPerHour;
		this.noOfFeedbacks = noOfFeedbacks;
	}

	/**
	 * @return the meetingRoomName
	 */
	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	/**
	 * @param meetingRoomName the meetingRoomName to set
	 */
	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	/**
	 * @return the seatingCapacity
	 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	/**
	 * @param seatingCapacity the seatingCapacity to set
	 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * @return the amenities
	 */
	public List<String> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	public void addAmenity(String amenity) {
		this.amenities.add(amenity);
	}
	
	/**
	 * @return the creditsPerHour
	 */
	public float getCreditsPerHour() {
		return creditsPerHour;
	}

	/**
	 * @param creditsPerHour the creditsPerHour to set
	 */
	public void setCreditsPerHour(float creditsPerHour) {
		this.creditsPerHour = creditsPerHour;
	}

	/**
	 * @return the meetingRoomId
	 */
	public int getMeetingRoomId() {
		return meetingRoomId;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @return the noOfFeedbacks
	 */
	public int getNoOfFeedbacks() {
		return noOfFeedbacks;
	}

	@Override
	public String toString() {
		return "MeetingRoom [meetingRoomId=" + meetingRoomId + ", meetingRoomName=" + meetingRoomName
				+ ", seatingCapacity=" + seatingCapacity + ", rating=" + rating + ", Amenities="
				+ amenities.toString() + ", creditsPerHour=" + creditsPerHour + ", noOfFeedbacks=" + noOfFeedbacks
				+ "]";
	}

	

	

}
