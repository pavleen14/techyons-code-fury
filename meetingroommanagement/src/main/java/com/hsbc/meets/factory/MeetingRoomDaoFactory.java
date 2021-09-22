package com.hsbc.meets.factory;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;
/**
 * This class is intensity to make object of {@link MeetingRoomDbDaoImpl} class
 * @author ShubhraBhuniaGhosh
 *
 */
public abstract class MeetingRoomDaoFactory {
	
	/**
	 * @author ShubhraBhuniaGhosh
	 * @return object of class {@link MeetingRoomDbDaoImpl}
	 */
	public static MeetingRoomDao getMeetingRoomDaoObject() {
		return (MeetingRoomDao) new MeetingRoomDbDaoImpl();
	}

}
