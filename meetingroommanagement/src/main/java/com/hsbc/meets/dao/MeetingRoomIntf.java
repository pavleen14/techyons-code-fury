/**
 * The Data Access layer Interface for the class MeetingRoom 
 * 
 * @author pavleen
 * @since 0.0.1
 */

package com.hsbc.meets.dao;

import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;

public interface MeetingRoomIntf {

	public MeetingRoom addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;

	public void updateMeetingRoomById(MeetingRoom meetingRoom) throws MeetingRoomDoesNotExistsException;

	public List<MeetingRoom> showAllMeetingRooms();

}
