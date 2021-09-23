package com.hsbc.meets.factory;

import com.hsbc.meets.service.impl.MeetingRoomServiceImpl;
/**
 * This factory class allows the object of subclass
 * to choose the type of object which it wants to create.  
 * 
 * @author PavleenKaur
 *
 *
 */
public class MeetingRoomServiceFactory {
		
		public static MeetingRoomServiceImpl getService() {
			
			MeetingRoomServiceImpl meetService = new MeetingRoomServiceImpl();
			
			return meetService; 
			
		}

	}


