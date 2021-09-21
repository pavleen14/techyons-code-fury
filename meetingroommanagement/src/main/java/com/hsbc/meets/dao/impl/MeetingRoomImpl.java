package com.hsbc.meets.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.hsbc.meets.dao.MeetingRoomIntf;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;

public class MeetingRoomImpl implements MeetingRoomIntf {
	List<MeetingRoom> roomList = new ArrayList<>();

	public MeetingRoomImpl() {
		String amenities1[] = { "Projector", "Wifi-Connection" };
		String amenities2[] = { "Whiteboard", "WaterDispenser" };
		roomList.add(new MeetingRoom(101, "Conference Room", 20, 4.5f, amenities1, 20, 0));
		roomList.add(new MeetingRoom(102, "Online Training", 30, 3.5f, amenities2, 20, 6));

	}

	@Override
	public MeetingRoom addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException {

		for (MeetingRoom meet : roomList) {
			if (meet.getMeetingRoomId() == meetingRoom.getMeetingRoomId())
				throw new MeetingRoomAlreadyExistsException("Meeting Room with this ID already exists");
		}
		roomList.add(meetingRoom);
		return meetingRoom;
	}

	@Override
	public List<MeetingRoom> showAllMeetingRooms() {

		return roomList;
	}

	@Override
	public void updateMeetingRoomById(MeetingRoom meetingRoom) throws MeetingRoomDoesNotExistsException {

	}

}
