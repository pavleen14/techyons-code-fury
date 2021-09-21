package com.hsbc.meets.factory;

import com.hsbc.meets.service.impl.MeetingRoomServiceImpl;

public class MeetingRoomFactory {
	
		
		public static MeetingRoomServiceImpl serviceFactory() {
			
			MeetingRoomServiceImpl meetService = new MeetingRoomServiceImpl();
			
			return meetService; 
			
		}

	}


