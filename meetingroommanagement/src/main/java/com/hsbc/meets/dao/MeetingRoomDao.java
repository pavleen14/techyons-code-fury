/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.dao;

import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;


public interface MeetingRoomDao {
	public void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;
	public List <MeetingRoom> displayMeetingRoom();
	public int updateMeetingRoomById(MeetingRoom newMeetingRoom) throws MeetingRoomNameAlreadyExistException, MeetingRoomDoesNotExistsException;
	public int deleteAminitiesByMeetingRoomById(int meetingRoomId);
	public int getAminitieIdByAminitieName(String amenitieName) throws MeetingRoomAmenitiesInvalidException;
	public int insertAminitieByMeetingRoomById(int meetingRoomId, String amenitieName) throws MeetingRoomAmenitiesInvalidException;
	public boolean checkMeetingRoomNameAlreadyExists(String meetingRoomName,int meetingRoomId) throws MeetingRoomNameAlreadyExistException;
}
