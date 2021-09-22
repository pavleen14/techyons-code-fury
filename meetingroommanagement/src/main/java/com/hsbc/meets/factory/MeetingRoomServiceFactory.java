package com.hsbc.meets.factory;

import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;
import com.hsbc.meets.service.MeetingRoomService;
import com.hsbc.meets.service.impl.MeetingRoomServiceImpl;
/**
 * This class is intensity to make object of {@link MeetingRoomServiceImpl} class
 * @author ShubhraBhuniaGhosh
 *
 */
public abstract class MeetingRoomServiceFactory {
	/**
	 * @author ShubhraBhuniaGhosh
	 * @return object of class {@link MeetingRoomServiceImpl}
	 */
	public static MeetingRoomService getMeetingRoomServiceObject() {
		return (MeetingRoomService) new MeetingRoomServiceImpl();
	}
}
