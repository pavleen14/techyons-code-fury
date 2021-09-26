package com.hsbc.meets.dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.NotEnoughSeatsException;
import com.hsbc.meets.exception.SlotNotAvailableException;
import com.hsbc.meets.exception.SomethingWentWrongException;
/**
 * This interface declare all the methods to be implemented in meeting Dao classes.
 * @author ShubhraBhuniaGhosh
 *
 */
public interface MeetingDao {

	/**
	 * This method gives a list of all suitable meeting room.
	 * @author ShubhraBhuniaGhosh
	 * @param startDateTime
	 * @param endDateTime
	 * @param type
	 * @param capacity
	 * @return a list of all suitable meeting room.
	 */
	public List<MeetingRoom> getMeetingRooms(Calendar startDateTime, Calendar endDateTime, String type, int capacity);
	/**
	 * This method checks if meeting title entered Already Exists.
	 * @author ShubhraBhuniaGhosh
	 * @param MeetingRoomName
	 * @return true if it already exists else returns false
	 */
	public boolean checkMeetingNameAlreadyExists(String meetingTitle);
	/**
	 * This method checks Seat Capacity By Meeting RoomName.
	 * @author ShubhraBhuniaGhosh
	 * @param MeetingRoomName
	 * @return true if Seat Capacity is grater than or equal to no of attendees
	 * @throws NotEnoughSeatsException 
	 */
	public boolean checkSeatCapacityByMeetingRoomId(int MeetingRoomId,int noOfAttendees) throws NotEnoughSeatsException;
	/**
	 * This method if meeting room is free at given slot.
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomId
	 * @return returns true if meeting room is free at given slot else returns false
	 * @throws SlotNotAvailableException 
	 */
	public boolean checkMeetingSlotIsFreeByMeetingRoomId(int meetingRoomId) throws SlotNotAvailableException;
	/**
	 * This method gets list of all Users.
	 * @author ShubhraBhuniaGhosh
	 * @return list of all users
	 */
	public List<User> getAllUsers();
	/**
	 * This method inserts Value of Meeting in database.
	 * @author ShubhraBhuniaGhosh
	 * @param bookedMeeting
	 * @throws MeetingTitleInvalidException 
	 * @throws SQLException
	 * @return no of rows updated
	 */
	public int insertValueOfMeeting(Meeting bookedMeeting, int managerId, int meetingRoomId) throws MeetingTitleInvalidException;
	/**
	 * This method adds attendees in database.
	 * @author ShubhraBhuniaGhosh
	 * @param attendees
	 * @param meetingId
	 * @return no of rows updated
	 */
	public int addAttendees(List<User> attendees,int meetingId) throws SomethingWentWrongException;

	/**
	 * This method deducts Manager Credit By Meeting RoomName.
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomName
	 * @param managerId
	 * @return no of rows updated
	 */
	public int deductManagerCreditByMeetingRoomName(String meetingRoomName,int managerId);
	/**
	 * 
	 * @param meetingRoomId
	 * @return amenities name list by meeting room id
	 */
	public List<String> getMeetingRoomAmenityByMeetingRoomId(int meetingRoomId);
}
