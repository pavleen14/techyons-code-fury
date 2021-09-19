/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.dao.impl;

import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;

public class MeetingRoomDbDaoImpl {
	
	void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException{
	}

	void updateMeetingRoomById(MeetingRoom meetingRoom) throws MeetingRoomDoesNotExistsException{
		getRoomNameById(meetingRoom.getMeetingRoomName());
	/*call to get the id because we cannot call by name and also change the name ad if we are taking all the information from controller directly we are not sending the rom id to the controller or service layer for that matter*/
	}
	List <MeetingRoom> displayMeetingRoom(){
		return null;
	}
	MeetingRoom getRoomNameById(String meetingRoomName){
		return null;
	}
}
