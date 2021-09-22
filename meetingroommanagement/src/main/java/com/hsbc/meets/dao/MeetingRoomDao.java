package com.hsbc.meets.dao;

import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;
/**
 * This interface declare all the methods to be implemented in meeting room Dao classes.
 * 
 * @author ShubhraBhuniaGhosh
 *
 */
public interface MeetingRoomDao {
	public void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;
	public List <MeetingRoom> displayMeetingRoom();
	/**
	 * This method updates the meeting room details in the database using meetingRoomId.
	 * If no data with the  given meetingRoomId is found then the method throws 
	 * {@link MeetingRoomDoesNotExistsException}. In case it there is an unexpected exception it returns -1.
	 * @author ShubhraBhuniaGhosh
	 * @param newMeetingRoom
	 * @return no of rows affected
	 * @throws MeetingRoomDoesNotExistsException
	 */
	public int updateMeetingRoomById(MeetingRoom newMeetingRoom) throws MeetingRoomDoesNotExistsException;
	/**
	 * This methods deletes all the existing amenities present for the respected Meeting Room from the database. 
	 * In case it there is an unexpected exception it returns -1.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomId
	 * @return no of rows affected
	 */
	public int deleteAmenitiesByMeetingRoomById(int meetingRoomId);
	/**
	 * This method gets amenity id or the respective amenity name. In case no such amenity exist in the database 
	 * it throws {@link MeetingRoomAmenitiesInvalidException}.
	 * In case it there is an unexpected event it returns -1.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @param amenityName
	 * @return no of rows affected
	 * @throws MeetingRoomAmenitiesInvalidException
	 */
	public int getAmenityIdByAmenityName(String amenityName) throws MeetingRoomAmenitiesInvalidException;
	/**
	 * This method inserts amenity using amenity id and meeting room id. it calls 
	 * {@link #getAmenityIdByAmenityName(String amenityName) getAmenityIdByAmenityName} to get the amenity id.
	 * In case it there is an unexpected event it returns -1.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomId
	 * @param amenityName
	 * @return no of rows affected
	 * @throws MeetingRoomAmenitiesInvalidException
	 */
	public int insertAmenityInAmenityMeetingRoomById(int meetingRoomId, String amenityName) throws MeetingRoomAmenitiesInvalidException;
	/**
	 * This method checks if meeting room name already exists in the database except in that data itself.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomName
	 * @param meetingRoomId
	 * @return if meeting room name already exists
	 * @throws MeetingRoomNameAlreadyExistException
	 */
	public boolean checkMeetingRoomNameAlreadyExists(String meetingRoomName,int meetingRoomId) throws MeetingRoomNameAlreadyExistException;
	/**
	 * This method returns a list of all amenities present in amenity-table in database.
	 * 
	 * @author ShubhraBhuniaGhosh
	 * @return list of all amenities
	 */
	public List<String> getAllAmenities();
}
