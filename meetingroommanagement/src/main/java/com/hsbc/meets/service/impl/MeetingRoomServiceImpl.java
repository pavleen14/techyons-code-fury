package com.hsbc.meets.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
import com.hsbc.meets.factory.MeetingRoomDaoFactory;
import com.hsbc.meets.service.MeetingRoomService;
import com.hsbc.meets.validation.MeetingRoomValidation;
/**
 * This class implements all the methods declared in {@link MeetingRoomService}
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingRoomServiceImpl implements MeetingRoomService{

	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public int editMeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities,
			int creditsPerHour, int rating, int noOfFeedbacks) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomDoesNotExistsException, MeetingRoomNameAlreadyExistException{

		MeetingRoomDao dao = MeetingRoomDaoFactory.getMeetingRoomDaoObject();
		int numberOfRowsUpdate = 0;
		if(MeetingRoomValidation.validateMeetingRoom(dao, meetingRoomId, meetingRoomName, seatingCapacity, amenities)) {
			MeetingRoom newMeetingRoom = new MeetingRoom(meetingRoomId,meetingRoomName, seatingCapacity, amenities,creditsPerHour,rating,noOfFeedbacks);
			numberOfRowsUpdate+=dao.updateMeetingRoomById(newMeetingRoom);
			dao.deleteAmenitiesByMeetingRoomById(newMeetingRoom.getMeetingRoomId());
			for(String amenityName:amenities) {
				numberOfRowsUpdate+=dao.insertAmenityInAmenityMeetingRoomById(meetingRoomId, amenityName);
			}
		}
		return numberOfRowsUpdate;
	}


//	public int calculateCredit(int seatingCapacity,List<String> amenities){
//		int craditPerHour = 0;
//
//		if(seatingCapacity>5 && seatingCapacity<=10) {
//			craditPerHour+=10;
//		}else if(seatingCapacity>10) {
//			craditPerHour+=20;
//		}
//
//		String [] listOfAmenities = {"projector", "wifi connection", "conference call facility", "whiteboard", "water dispenser", "tv", "coffee machine"};
//		int[] amenitiesCredits = {5,10,15,5,5,10,10};
//		for(String amenitie: amenities) {
//			for(int index = 0; index<listOfAmenities.length; index++) {
//				if(amenitie.toLowerCase().equals(listOfAmenities[index])) {
//					craditPerHour+=amenitiesCredits[index];
//					break;
//				}
//			}	
//		}
//
//		return craditPerHour;
//
//	}
//
//	public int updateRating(int noOfFeedbacks, int rating, List<Integer> newRatingList){
//		int currentRating = rating*noOfFeedbacks;
//		noOfFeedbacks+=newRatingList.size();
//		for(int newRating: newRatingList) {
//			rating+=newRating;
//		}
//		rating = (int)rating/noOfFeedbacks;
//		return rating;
//
//	}
	public static void main(String[] args) throws MeetingRoomDoesNotExistsException, MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomNameAlreadyExistException {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("conference call facility");
		arr.add("whiteboard");
		MeetingRoomServiceImpl m= new MeetingRoomServiceImpl();
		System.out.println(m.editMeetingRoom(55, "pakodnora", 33, arr, 0, 0, 0));
	}

}
