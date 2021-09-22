package com.hsbc.meets.service;

import java.util.List;

import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
/**
 * This interface declare all the methods to be implemented in meeting room service classes.
 * @author ShubhraBhuniaGhosh
 */
public interface MeetingRoomService {
	/**
	 * This method gets instance of {@link com.hsbc.meets.validation.MeetingRoomValidation#validateMeetingRoom(com.hsbc.meets.dao.MeetingRoomDao, int, String, int, List) validateMeetingRoom}. 
	 * It checks if all the meeting room details are according to validation rules using {@link validateMeetingRoom}.
	 * If all the meeting room details are according to validation rules then we edit the meeting details to new details.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomId
	 * @param meetingRoomName
	 * @param seatingCapacity
	 * @param amenities
	 * @param creditsPerHour
	 * @param rating
	 * @param noOfFeedbacks
	 * @return no of rows updated
	 * @throws MeetingRoomNameInvalidException
	 * @throws MeetingRoomSeatingCapacityInalidException
	 * @throws MeetingRoomAmenitiesInvalidException
	 * @throws MeetingRoomDoesNotExistsException
	 * @throws MeetingRoomNameAlreadyExistException
	 */
	public int editMeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities,
			int creditsPerHour, int rating, int noOfFeedbacks) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomDoesNotExistsException, MeetingRoomNameAlreadyExistException;
}
