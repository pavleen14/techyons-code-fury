package com.hsbc.meets.factory;

import com.hsbc.meets.service.MeetingRoomService;
import com.hsbc.meets.service.impl.MeetingRoomServiceImpl;

public abstract class MeetingRoomServiceFactory {
	public static MeetingRoomService getMeetingRoomServiceObject() {
		return (MeetingRoomService) new MeetingRoomServiceImpl();
	}
}
