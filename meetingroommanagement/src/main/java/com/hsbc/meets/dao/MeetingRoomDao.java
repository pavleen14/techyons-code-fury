/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.dao;

import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;


public interface MeetingRoomDao {
	void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;
	void updateMeetingRoomById(MeetingRoom meetingRoom) throws MeetingRoomDoesNotExistsException;
	List <MeetingRoom> displayMeetingRoom();
	MeetingRoom getRoomNameById(String meetingRoomName);
}
