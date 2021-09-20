/**
 * @author ShubharBhuniaGhosh
 */

package com.hsbc.meets.validation;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
import com.hsbc.meets.factory.MeetingRoomDaoFactory;

public abstract class MeetingRoomValidation {

	private static boolean validateMeetingRoomName(String name) throws MeetingRoomNameInvalidException {

		if(name.length()<4 || name.length()>20) {
			throw new MeetingRoomNameInvalidException();
		}
		name = name.toLowerCase();
		char[] nameCharacterArray = name.toCharArray();
		for (int i = 0; i < nameCharacterArray.length; i++) {
			char ch = nameCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingRoomNameInvalidException();
			}
		}
		return true;
	}


	private static boolean validateMeetingRoomSeatingCapacity(int seatingCapacity) throws MeetingRoomSeatingCapacityInalidException {
		if(seatingCapacity>=6 && seatingCapacity<=250) {
			return true;
		}
		throw new MeetingRoomSeatingCapacityInalidException();
	}


	private static boolean validateMeetingRoomAmenities(List<String> amenities) throws MeetingRoomAmenitiesInvalidException{
		if(amenities.size()<2 || amenities.size()>7) {
			throw new MeetingRoomAmenitiesInvalidException();
		}
		ArrayList<Integer> amenitiesIdList = new ArrayList<Integer>();
		for(String amenitie: amenities) {
			boolean inAvailableAmenities = false;
			if(MeetingRoomDaoFactory.getMeetingRoomDaoObject().getAminitieIdByAminitieName(amenitie)==-1) {
				throw new MeetingRoomAmenitiesInvalidException();
			}
		}
		return true;
	}


	public static boolean validateMeetingRoom(String meetingRoomName, int seatingCapacity, List<String> amenities) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException{
		if(MeetingRoomValidation.validateMeetingRoomName(meetingRoomName) && MeetingRoomValidation.validateMeetingRoomSeatingCapacity(seatingCapacity) && MeetingRoomValidation.validateMeetingRoomAmenities(amenities)) {
			return true;
		}
		return false;

	}

}
