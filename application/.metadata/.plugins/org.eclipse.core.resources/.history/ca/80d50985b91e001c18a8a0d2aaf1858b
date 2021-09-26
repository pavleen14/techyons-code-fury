package com.hsbc.meets.factory;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.dao.impl.MeetingDbDaoImpl;
/**
 * This class is to create an instance of MeetingDao implementing classes.
 * @author ShubhraBhuniaGhosh
 *
 */
public abstract class MeetingDaoFactory {
	/**
	 * @author ShubhraBhuniaGhosh
	 * @return object of {@link MeetingDbDaoImpl}
	 */
	public static MeetingDao getMeetingDaoObject() {
		return new MeetingDbDaoImpl();
	}
}
