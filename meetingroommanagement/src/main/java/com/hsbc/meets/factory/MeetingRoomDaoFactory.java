/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.factory;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;

public abstract class MeetingRoomDaoFactory {
	
	public static MeetingRoomDao getMeetingRoomDaoObject() {
		return (MeetingRoomDao) new MeetingRoomDbDaoImpl();
	}

}
