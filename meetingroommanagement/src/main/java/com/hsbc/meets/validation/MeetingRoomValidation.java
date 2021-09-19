package com.hsbc.meets.validation;

import java.util.List;

import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;

public abstract class MeetingRoomValidation {
	
	public static boolean validateMeetingRoomName(String name) throws MeetingRoomNameInvalidException {
		
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

	
	public static boolean validateMeetingRoomSeatingCapacity(int seatingCapacity) throws MeetingRoomSeatingCapacityInalidException {
		if(seatingCapacity>=6 && seatingCapacity<=250) {
			return true;
		}
		throw new MeetingRoomSeatingCapacityInalidException();
	}
	
	
	public static boolean validateMeetingRoomAmenities(List<String> amenities) throws MeetingRoomAmenitiesInvalidException{
		if(amenities.size()<2 || amenities.size()>7) {
			throw new MeetingRoomAmenitiesInvalidException();
		}
		String [] listOfAmenities = {"projector", "wifi connection", "conference call facility", "whiteboard", "water dispenser", "tv", "coffee machine"};
		boolean[] isInAmenitiesList = {false,false,false,false,false,false,false};
		for(String amenitie: amenities) {
			boolean inAvailableAmenities = false;
			for(int index = 0; index<listOfAmenities.length; index++) {
				if(amenitie.toLowerCase().equals(listOfAmenities[index]) && !isInAmenitiesList[index]) {
					isInAmenitiesList[index] = true;
					inAvailableAmenities = true;
					break;
				}
			}
			if(!inAvailableAmenities) {
				throw new MeetingRoomAmenitiesInvalidException();
			}	
		}
		return true;
	}
	
	
	public static boolean validateMeetingRoom(String name, int seatingCapacity, List<String> amenities) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException{
		if(MeetingRoomValidation.validateMeetingRoomName(name) && MeetingRoomValidation.validateMeetingRoomSeatingCapacity(seatingCapacity) && MeetingRoomValidation.validateMeetingRoomAmenities(amenities)) {
			return true;
		}
		return false;
		
	}
}
