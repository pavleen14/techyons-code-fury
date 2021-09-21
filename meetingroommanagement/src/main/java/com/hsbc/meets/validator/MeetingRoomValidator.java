package com.hsbc.meets.validator;

import com.hsbc.meets.exception.MeetingRoomNameInvalid;

public class MeetingRoomValidator {
	
	private static boolean validateMeetingRoomName(String name) throws MeetingRoomNameInvalid {

		if(name.length()<4 || name.length()>20) {
			throw new MeetingRoomNameInvalid();
		}
		name = name.toLowerCase();
		char[] nameCharacterArray = name.toCharArray();
		for (int i = 0; i < nameCharacterArray.length; i++) {
			char ch = nameCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingRoomNameInvalid();
			}
		}
		return true;
	}

}
