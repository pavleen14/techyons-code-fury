/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.factory;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;

public class MeetingRoomDaoFactory {
	
	public static MeetingRoomDao getDaoObject() {
		return (MeetingRoomDao) new MeetingRoomDbDaoImpl();
	}

}
