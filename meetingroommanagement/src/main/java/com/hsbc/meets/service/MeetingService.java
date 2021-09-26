 package com.hsbc.meets.service;

import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidByMeetingTypeException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;
import com.hsbc.meets.exception.NotEnoughSeatsException;
import com.hsbc.meets.exception.SlotNotAvailableException;
import com.hsbc.meets.exception.SomethingWentWrongException;
/**
 * This interface declare all the methods to be implemented in meeting service classes.
 * @author ShubhraBhuniaGhosh
 */
public interface MeetingService {
	/**
	 * This method sets Meeting Booking Information In Local Object.
	 * @author ShubhraBhuniaGhosh
	 * @param meetingTitle
	 * @param startDateTime
	 * @param endDateTime
	 * @param durationInMinuts
	 * @param meetingType
	 * @throws MeetingTitleInvalidException
	 * @throws MeetingStartDateTimeInvalidException
	 * @throws MeetingDurationInvalidException
	 * @throws MeetingTypeInvalidException
	 * @return returns true is runs successfully 
	 */
	public boolean setMeetingBookingInformation(String meetingTitle,Calendar startDateTime,Calendar endDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException;
	/**
	 * This method get a list of All Users in the database.
	 * @author ShubhraBhuniaGhosh
	 * @return list of all users detail in format name (email)
	 */
	public List<String> getAllUsers();
	/**
	 * This method sets Attendees List In Local Object.
	 * @author ShubhraBhuniaGhosh
	 * @param attendees
	 * @return true
	 */
	public boolean setAttendeesList(List<String> attendees);
	/**
	 * This method gets a list of All Available Meeting Rooms.
	 * @author ShubhraBhuniaGhosh
	 * @return list of available meeting rooms
	 */
	public List<MeetingRoom> getAllAvailableMeetingRooms();
	/**
	 * This method sets Booked Meeting Room In Local Object and validates if the meeting room have required 
	 * Amenities with respect to the meeting type.
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoom
	 * @return true
	 * @throws MeetingRoomAmenitiesInvalidByMeetingTypeException 
	 * @throws NotEnoughSeatsException 
	 * @throws SlotNotAvailableException 
	 */
	public boolean setBookedMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAmenitiesInvalidByMeetingTypeException, NotEnoughSeatsException, SlotNotAvailableException;
	/**
	 * This method books Meeting.
	 * @author ShubhraBhuniaGhosh
	 * @return no of rows updated
	 * @throws NotEnoughCreditsException
	 * @throws MeetingTitleInvalidException 
	 * @throws SomethingWentWrongException 
	 */
	public int bookMeeting() throws NotEnoughCreditsException, MeetingTitleInvalidException, SomethingWentWrongException;
}