package com.hsbc.meets.validation;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
import com.hsbc.meets.factory.MeetingRoomDaoFactory;

/**
 * The class contains the different validations which have
 * been applied while creating and editing meeting rooms.   
 * 
 * @author ShubraBhuniaGhosh
 * @author PavleenKaur
 * @author alan
 *
 */
public class MeetingRoomValidation {

	private int meetingRoomId;
	private String name;
	private int capacity;
	private List<String> amenities;
	
	private MeetingRoomDao dao;
	
	/**
	 * @param meetingRoomId
	 * @param name
	 * @param capacity
	 * @param amenities
	 * @throws MeetingRoomAlreadyExistsException 
	 * @throws MeetingRoomAmenitiesInvalidException 
	 * @throws MeetingRoomSeatingCapacityInalidException 
	 * @throws MeetingRoomNameInvalidException 
	 */
	public MeetingRoomValidation(int meetingRoomId, String name, int capacity, List<String> amenities) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomAlreadyExistsException {
		super();
		this.meetingRoomId = meetingRoomId;
		this.name = name;
		this.capacity = capacity;
		this.amenities = amenities;
		this.dao = MeetingRoomDaoFactory.getMeetingRoomDaoObject();
		this.validateMeetingRoom();
	}
	
	/**
	 * @param name
	 * @param capacity
	 * @param amenities
	 * @throws MeetingRoomAlreadyExistsException 
	 * @throws MeetingRoomAmenitiesInvalidException 
	 * @throws MeetingRoomSeatingCapacityInalidException 
	 * @throws MeetingRoomNameInvalidException 
	 */
	public MeetingRoomValidation( String name, int capacity, List<String> amenities) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomAlreadyExistsException {
		super();
		this.meetingRoomId = -1;
		this.name = name;
		this.capacity = capacity;
		this.amenities = amenities;
		this.dao = MeetingRoomDaoFactory.getMeetingRoomDaoObject();
		this.validateMeetingRoom();
	}
	
	
	
	/**
	 * This method validates meeting room name according to following rules.
	 * Meeting room name should be at least 4 letters long and at max 20 letters long.
	 * It can only contain letters.
	 * Numbers and special characters in the name are not allowed.
	 * The name should not be duplicate.
	 * @author ShubhraBhuniaGhosh
	 
	 * @param name
	 * @return if the meeting room name is valid
	 * @throws MeetingRoomNameInvalidException
	 * @throws MeetingRoomAlreadyExistsException
	 */
	private boolean validateMeetingRoomName() throws MeetingRoomNameInvalidException, MeetingRoomAlreadyExistsException {

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
		return !dao.checkMeetingRoomNameAlreadyExists(name, meetingRoomId);
	}
	
	/**
	 * This method validates meeting room seating capacity according to following rule.
	 * Seating Capacity should be greater than or equal to 6 and less than or equal to 250.
	 * @author ShubhraBhuniaGhosh
	 * @param seatingCapacity
	 * @return if the meeting room seating capacity is valid
	 * @throws MeetingRoomSeatingCapacityInalidException
	 */
	private boolean validateMeetingRoomSeatingCapacity() throws MeetingRoomSeatingCapacityInalidException {
		if(capacity>=6 && capacity<=250) {
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
	private boolean validateMeetingRoomAmenities() throws MeetingRoomAmenitiesInvalidException{
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
	 * This method calls all validation functions
	 * to validate meeting room details
	 * 
	 * @author alan
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
	public boolean validateMeetingRoom() throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomAlreadyExistsException{
		if(validateMeetingRoomName() && validateMeetingRoomSeatingCapacity() && validateMeetingRoomAmenities()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public MeetingRoom getRoom() {
		return new MeetingRoom(meetingRoomId, name, capacity, name, 0);
	}
	
	
}
