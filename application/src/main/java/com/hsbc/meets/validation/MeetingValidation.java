package com.hsbc.meets.validation;


import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidByMeetingTypeException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.factory.MeetingFactory;


public abstract class MeetingValidation {
	
	/**
	 * This method validates meetingType using {@link #validateMeetingMeetingType() validateMeetingMeetingType} 
	 * durationInMinuts using {@link #validateMeetingDurationInMinuts() validateMeetingDurationInMinuts} 
	 * startDateTime  using {@link #validateMeetingStartDateTime() validateMeetingStartDateTime} 
	 * meetingTitle  using {@link #validateMeetingTitle() validateMeetingTitle} 
	 * @param dao
	 * @param meetingTitle
	 * @param startDateTime
	 * @param durationInMinuts
	 * @param meetingType
	 * @return
	 * @throws MeetingTitleInvalidException
	 * @throws MeetingStartDateTimeInvalidException
	 * @throws MeetingDurationInvalidException
	 * @throws MeetingTypeInvalidException
	 */
	public static boolean validateMeetingInformation(MeetingDao dao, String meetingTitle,Calendar startDateTime,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException{
		if(validateMeetingTitle(dao, meetingTitle) && validateMeetingStartDateTime(startDateTime)  && validateMeetingType(meetingType)){
			return true;
		}
		return false;
	}
	/**
	 * This method validates Meeting Type
	 * @param meetingType
	 * @return
	 * @throws MeetingTypeInvalidException
	 */
	public static boolean validateMeetingType(String meetingType) throws MeetingTypeInvalidException {
		System.out.println(meetingType);
		if(meetingType.equals("CLASSROOM_TRAINING") || meetingType.equals("ONLINE_TRAINING") || meetingType.equals("CONFERENCE_CALL") || meetingType.equals("BUSINESS")) {
			return true;
		}
		throw new MeetingTypeInvalidException();
	}
	/**
	 * This method validates Meeting Duration In Minutes
	 * @param durationInMinuts
	 * @return
	 * @throws MeetingDurationInvalidException
	 */
	private static boolean validateMeetingDurationInMinuts(int durationInMinuts) throws MeetingDurationInvalidException {			
		if(durationInMinuts>=30 && durationInMinuts<=540)
			return true;
		throw new MeetingDurationInvalidException();
	}
	/**
	 * This method validates Meeting Start Date Time
	 * @param startDateTime
	 * @return
	 * @throws MeetingStartDateTimeInvalidException
	 */
	private static boolean validateMeetingStartDateTime(Calendar startDateTime) throws MeetingStartDateTimeInvalidException {			
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 1);
		if(startDateTime.compareTo(today)==-1) {
			throw new MeetingStartDateTimeInvalidException();
		}
		return true;
	}
	/**
	 * This method validates Meeting Title
	 * @param dao
	 * @param meetingTitle
	 * @return
	 * @throws MeetingTitleInvalidException
	 */
	private static boolean validateMeetingTitle(MeetingDao dao, String meetingTitle) throws MeetingTitleInvalidException {			
		if(meetingTitle.length()<4 || meetingTitle.length()>20) {
			throw new MeetingTitleInvalidException();
		}
		meetingTitle = meetingTitle.toLowerCase();
		char[] titleCharacterArray = meetingTitle.toCharArray();
		for (int i = 0; i < titleCharacterArray.length; i++) {
			char ch = titleCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingTitleInvalidException();
			}
		}
		if(dao.checkMeetingNameAlreadyExists(meetingTitle))
			throw new MeetingTitleInvalidException();
		return true;
	}
	/**
	 * 
	 * @param managerCradit
	 * @param meetingRoomCraditsPerHour
	 * @return true if manager credit more than credit per hour
	 */
	public static boolean validateManagerCredits(int managerCradit, float meetingRoomCraditsPerHour) {
		return (managerCradit>=meetingRoomCraditsPerHour);

	}
	/**
	 * 
	 * @param dao
	 * @param meetingRoomId
	 * @param meetigType
	 * @return true if amenities of selected room are valid withrespect to meeting type
	 * @throws MeetingRoomAmenitiesInvalidByMeetingTypeException 
	 */
	public static boolean validateAmenitiesPresentByMeetingType(MeetingDao dao, int meetingRoomId, String meetigType) throws MeetingRoomAmenitiesInvalidByMeetingTypeException {
		List<String> amenities = dao.getMeetingRoomAmenityByMeetingRoomId(meetingRoomId);
		int flag = -2;
		switch (meetigType) {
		case "CLASSROOM_TRAINING":
			for(String amenity: amenities) {
				if(amenity.equals("whiteboard")) {
					flag++;
				}else if(amenity.equals("projector")) {
					flag++;
				}
			}
			break;
		case "ONLINE_TRAINING":
			for(String amenity: amenities) {
				if(amenity.equals("wifi connection")) {
					flag++;
				}else if(amenity.equals("projector")) {
					flag++;
				}
			}

			break;
		case "CONFERENCE_CALL":
			for(String amenity: amenities) {
				if(amenity.equals("conference call facility")) {
					flag+=2;
				}
			}

			break;
		case "BUSINESS":
			for(String amenity: amenities) {
				if(amenity.equals("projector")) {
					flag+=2;
				}
			}

			break;
		default:
			break;
		}
		if(flag==0) {
			return true;
		}else {
			throw new MeetingRoomAmenitiesInvalidByMeetingTypeException();
		}
	}
}
