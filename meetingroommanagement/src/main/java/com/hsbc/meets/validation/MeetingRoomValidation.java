package com.hsbc.meets.validation;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
import com.hsbc.meets.factory.MeetingRoomDaoFactory;
/**
 * This class contains all the methods to validate meeting room details
 * @author ShubhraBhuniaGhosh
 *
 */
public abstract class MeetingRoomValidation {
	/**
	 * This method validates meeting room name according to following rules.
	 * Meeting room name should be at least 4 letters long and at max 20 letters long.
	 * It can only contain letters.
	 * Numbers and special characters in the name are not allowed.
	 * The name should not be duplicate.
	 * @author ShubhraBhuniaGhosh
	 * @param dao
	 * @param meetingRoomId
	 * @param meetigRoomName
	 * @return if the meeting room name is valid
	 * @throws MeetingRoomNameInvalidException
	 * @throws MeetingRoomNameAlreadyExistException
	 */
	private static boolean validateMeetingRoomName(MeetingRoomDao dao, int meetingRoomId, String meetigRoomName) throws MeetingRoomNameInvalidException, MeetingRoomNameAlreadyExistException {

		if(meetigRoomName.length()<4 || meetigRoomName.length()>20) {
			throw new MeetingRoomNameInvalidException();
		}
		meetigRoomName = meetigRoomName.toLowerCase();
		char[] nameCharacterArray = meetigRoomName.toCharArray();
		for (int i = 0; i < nameCharacterArray.length; i++) {
			char ch = nameCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingRoomNameInvalidException();
			}
		}
		return !dao.checkMeetingRoomNameAlreadyExists(meetigRoomName, meetingRoomId);
	}

	/**
	 * This method validates meeting room seating capacity according to following rule.
	 * Seating Capacity should be greater than or equal to 6 and less than or equal to 250.
	 * @author ShubhraBhuniaGhosh
	 * @param seatingCapacity
	 * @return if the meeting room seating capacity is valid
	 * @throws MeetingRoomSeatingCapacityInalidException
	 */
	private static boolean validateMeetingRoomSeatingCapacity(int seatingCapacity) throws MeetingRoomSeatingCapacityInalidException {
		if(seatingCapacity>=6 && seatingCapacity<=250) {
			return true;
		}
		throw new MeetingRoomSeatingCapacityInalidException();
	}

	/**
	 * This method checks if the mentioned amenities are valid.
	 * @author ShubhraBhuniaGhosh
	 * @param dao
	 * @param amenities
	 * @return if the meeting room details are valid
	 * @throws MeetingRoomAmenitiesInvalidException
	 */
	private static boolean validateMeetingRoomAmenities(MeetingRoomDao dao, List<String> amenities) throws MeetingRoomAmenitiesInvalidException{
		if(amenities.size()<2 || amenities.size()>7) {
			throw new MeetingRoomAmenitiesInvalidException();
		}
		ArrayList<Integer> amenitiesIdList = new ArrayList<Integer>();
		for(String amenitie: amenities) {
			if(dao.getAmenityIdByAmenityName(amenitie)==-1) {
				throw new MeetingRoomAmenitiesInvalidException();
			}
		}
		return true;
	}

	/**
	 * This method calls {@link #validateMeetingRoomName(MeetingRoomDao, int, String) validateMeetingRoomName} {@link #validateMeetingRoomSeatingCapacity(int) validateMeetingRoomSeatingCapacity} {@link #validateMeetingRoomAmenities(MeetingRoomDao, List) validateMeetingRoomAmenities} to validate meeting room details
	 * @author ShubhraBhuniaGhosh
	 * @param dao
	 * @param meetingRoomId
	 * @param meetingRoomName
	 * @param seatingCapacity
	 * @param amenities
	 * @return
	 * @throws MeetingRoomNameInvalidException
	 * @throws MeetingRoomSeatingCapacityInalidException
	 * @throws MeetingRoomAmenitiesInvalidException
	 * @throws MeetingRoomNameAlreadyExistException
	 */
	public static boolean validateMeetingRoom(MeetingRoomDao dao,int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomNameAlreadyExistException{
		if(MeetingRoomValidation.validateMeetingRoomName(dao, meetingRoomId, meetingRoomName) && MeetingRoomValidation.validateMeetingRoomSeatingCapacity(seatingCapacity) && MeetingRoomValidation.validateMeetingRoomAmenities(dao, amenities)) {
			return true;
		}
		return false;

	}

}
