package com.hsbc.meets.validator;

import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomNameInvalid;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInvalidException;

/**
 * The class contains the different validations which have
 * been applied while creating and editing meeting rooms.   
 * 
 * @author PavleenKaur
 *
 */
public class MeetingRoomValidator {
	
	private static boolean validateMeetingRoomName(String name) throws MeetingRoomNameInvalid {

		if(name.length()<4 || name.length()>20) {
			throw new MeetingRoomNameInvalid();
		}
		name = name.toLowerCase();
		char[] nameCharacterArray = name.toCharArray();
		for (int i = 0; i < nameCharacterArray.length; i++) {
			char ch = nameCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingRoomNameInvalid();
			}
		}
		return true;
	}
	
	private static boolean validateMeetingRoomSeatingCapacity(int seatingCapacity) throws MeetingRoomSeatingCapacityInvalidException {
		if(seatingCapacity>=6 && seatingCapacity<=250) {
			return true;
		}
		throw new MeetingRoomSeatingCapacityInvalidException();
	}


	private static boolean validateMeetingRoomAmenities(String[] amenities) throws MeetingRoomAmenitiesInvalidException{
		if(amenities.length<2 || amenities.length>7) {
			throw new MeetingRoomAmenitiesInvalidException();
		}
//		ArrayList<Integer> amenitiesIdList = new ArrayList<Integer>();
//		for(String amenitie: amenities) {
//			if(MeetingRoomDaoFactory.getMeetingRoomDaoObject().getAminitieIdByAminitieName(amenitie)==-1) {
//				throw new MeetingRoomAmenitiesInvalidException();
//			}
//		}
		return true;
	}


	public static boolean validateMeetingRoom(String meetingRoomName, int seatingCapacity, String[] amenities) throws MeetingRoomNameInvalid, MeetingRoomSeatingCapacityInvalidException, MeetingRoomAmenitiesInvalidException{
		if(MeetingRoomValidator.validateMeetingRoomName(meetingRoomName) && MeetingRoomValidator.validateMeetingRoomSeatingCapacity(seatingCapacity) && MeetingRoomValidator.validateMeetingRoomAmenities(amenities)) {
			return true;
		}
		return false;

	}

}
