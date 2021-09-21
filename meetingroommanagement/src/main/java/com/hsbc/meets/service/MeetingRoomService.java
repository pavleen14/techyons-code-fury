/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.service;

import java.util.List;

import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;

public interface MeetingRoomService {
	public boolean editMeetingRoom(int meetingRoomId, String meetingRoomName, int seatingCapacity, List<String> amenities,
			int creditsPerHour, int rating, int noOfFeedbacks) throws MeetingRoomNameInvalidException, MeetingRoomSeatingCapacityInalidException, MeetingRoomAmenitiesInvalidException, MeetingRoomDoesNotExistsException, MeetingRoomNameAlreadyExistException;
}
