/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.service.impl;

import java.util.List;

public class MeetingRoomService {

	void createNewMeetingRoom(String name, int seatingCapacity, List<String> amenities) {
		/*
		 * Check for validity
		 * If valid
		 * 		Calculate the new credit per hour
		 * 		Pass it to the dao layer
		 * 		set rating = 0 and noOfFeedback = 0
		 * 		create object
		 * 		pass to dao to store
		 *If not valid
		 *		Throw exception
		 */

	}

	void editMeetingRoom(String name, int seatingCapacity, List<String> amenities) {
		/*
		 * Get room name the admin wants to change from controller
		 * Along with that get the new room info from controller 
		 * Check if the room has any meetings booked
		 * If room has meetings booked:
		 * 		Throw exception
		 * If no meetings are booked
		 * 		Check for validity
		 * 		If valid
		 * 			Calculate the new credit per hour
		 * 			Pass it to the dao layer
		 * 		If not valid	
		 * 			Throw exception
		 */
	}
	int calculateCredit(int seatingCapacity,List<String> amenities){
		int craditPerHour = 0;
		
		if(seatingCapacity>5 && seatingCapacity<=10) {
			craditPerHour+=10;
		}else if(seatingCapacity>10) {
			craditPerHour+=20;
		}
		
		String [] listOfAmenities = {"projector", "wifi connection", "conference call facility", "whiteboard", "water dispenser", "tv", "coffee machine"};
		int[] amenitiesCredits = {5,10,15,5,5,10,10};
		for(String amenitie: amenities) {
			for(int index = 0; index<listOfAmenities.length; index++) {
				if(amenitie.toLowerCase().equals(listOfAmenities[index])) {
					craditPerHour+=amenitiesCredits[index];
					break;
				}
			}	
		}

		return craditPerHour;

	}

	int updateRating(int noOfFeedbacks, int rating, List<Integer> newRatingList){
		int currentRating = rating*noOfFeedbacks;
		noOfFeedbacks+=newRatingList.size();
		for(int newRating: newRatingList) {
			rating+=newRating;
		}
		rating = (int)rating/noOfFeedbacks;
		return rating;

	}

}
