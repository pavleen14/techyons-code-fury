package com.hsbc.meets.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.dao.impl.MeetingDbDaoImpl;
import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidByMeetingTypeException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;
import com.hsbc.meets.exception.NotEnoughSeatsException;
import com.hsbc.meets.exception.SlotNotAvailableException;
import com.hsbc.meets.exception.SomethingWentWrongException;
import com.hsbc.meets.factory.MeetingFactory;
import com.hsbc.meets.service.MeetingService;
import com.hsbc.meets.validation.MeetingValidation;

/**
 * This class implements {@link MeetingService}
 * @author tells
 *
 */
public class MeetingServiceImpl implements MeetingService{
	private User manager;
	private Meeting bookedMeeting;
	private MeetingDao dao;
	/**
	 * @author ShubhraBhuniaGhosh
	 * @param Manager
	 */
	public  MeetingServiceImpl(User Manager){
		this.manager = Manager;
		dao = MeetingFactory.getMeetingDaoObject();
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean setMeetingBookingInformation(String meetingTitle,Calendar startDateTime,Calendar endDateTime,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException {
		if(MeetingValidation.validateMeetingInformation(this.dao, meetingTitle, startDateTime, meetingType)) {
			this.bookedMeeting = new Meeting(meetingTitle, startDateTime, endDateTime, meetingType);
			bookedMeeting.setEndDateTime(endDateTime);
			System.out.println(bookedMeeting.getEndDateTime());
			return true;
		}
		return false;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<String> getAllUsers() {
		List<User> usersList = dao.getAllUsers();
		ArrayList<String> users = new ArrayList<String>();
		for (User oneUser : usersList) {
			users.add(oneUser.getName()+" ("+ oneUser.getEmail()+")");
		}
		return users;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean setAttendeesList(List<String> attendees){
		List<User> users = new ArrayList<>();
		for(String attende:attendees) {
			User u = new User();
			u.setEmail(attende.substring(attende.indexOf('(')+1, attende.length()-1));
			users.add(u);
		}
		bookedMeeting.setAttendees(users);
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<MeetingRoom> getAllAvailableMeetingRooms() {
		return dao.getMeetingRooms(bookedMeeting.getStartDateTime(), bookedMeeting.getEndDateTime(), bookedMeeting.getMeetingType(),0);
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 * @throws NotEnoughSeatsException 
	 * @throws SlotNotAvailableException 
	 * @throws MeetingRoomAmenitiesInvalidException 
	 */
	public boolean setBookedMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAmenitiesInvalidByMeetingTypeException, NotEnoughSeatsException, SlotNotAvailableException{
		if(MeetingValidation.validateAmenitiesPresentByMeetingType(dao,meetingRoom.getMeetingRoomId(),bookedMeeting.getMeetingType()) && dao.checkSeatCapacityByMeetingRoomId(meetingRoom.getMeetingRoomId(),bookedMeeting.getAttendees().size()) && dao.checkMeetingSlotIsFreeByMeetingRoomId(meetingRoom.getMeetingRoomId())) {
			bookedMeeting.setMeetingRoom(meetingRoom);
			return true;
		}
		return false;
	}
	public int bookMeeting() throws NotEnoughCreditsException, MeetingTitleInvalidException, SomethingWentWrongException {
		int totalRowsUpdated = 0;
		if(!MeetingValidation.validateManagerCredits(this.manager.getCredits(),bookedMeeting.getMeetingRoom().getCreditsPerHour())) {
			throw new NotEnoughCreditsException();
		}
		int meetingId = dao.insertValueOfMeeting(bookedMeeting, manager.getUserId(), bookedMeeting.getMeetingRoom().getMeetingRoomId());
		totalRowsUpdated+=1;
		totalRowsUpdated+=dao.addAttendees(bookedMeeting.getAttendees(),meetingId);
		return totalRowsUpdated;
	}
	
}
