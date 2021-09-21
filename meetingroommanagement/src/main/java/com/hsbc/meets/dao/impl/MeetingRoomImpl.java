package com.hsbc.meets.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hsbc.meets.dao.MeetingRoomIntf;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.factory.ConnectionFactory;

public class MeetingRoomImpl implements MeetingRoomIntf {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	List<MeetingRoom> roomList = new ArrayList<>();
	final String viewAllRooms = "select * from meetingroom";
	final String addMeetingRoomQuery = "insert into meetingroom values(?,?,?,?,?)";
	public MeetingRoomImpl() {
//  Commenting out the hard-coded data part which was used previously
//		String amenities1[] = { "Projector", "Wifi-Connection" };
//		String amenities2[] = { "Whiteboard", "WaterDispenser" };
//		roomList.add(new MeetingRoom(101, "Conference Room", 20, 4.5f, amenities1, 20, 0));
//		roomList.add(new MeetingRoom(102, "Online Training", 30, 3.5f, amenities2, 20, 6));
		conn = ConnectionFactory.getDBConnection();

	}

	@Override
	public MeetingRoom addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException {
//  Commenting out the part which was used previously without the DB 
//		for (MeetingRoom meet : roomList) {
//			if (meet.getMeetingRoomId() == meetingRoom.getMeetingRoomId())
//				throw new MeetingRoomAlreadyExistsException("Meeting Room with this ID already exists");
//		}
//		roomList.add(meetingRoom);
	
		
		try {
			String sql = "select count(*) from meetingroom where meetingroom_id = " + meetingRoom.getMeetingRoomId();
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			// checking
			if (rs != null) {
				throw new MeetingRoomAlreadyExistsException("Meeting Room Already Exists");
			}
			pstmt = conn.prepareStatement(addMeetingRoomQuery);
			pstmt.setInt(1, meetingRoom.getMeetingRoomId());
			pstmt.setString(2, meetingRoom.getMeetingRoomName());
			pstmt.setInt(3, meetingRoom.getSeatingCapacity());
			pstmt.setString(4, meetingRoom.getamenities());
			pstmt.setInt(5, meetingRoom.getCreditsPerHour());

			int i = pstmt.executeUpdate();
			if (i > 0)
				System.out.print("Insert successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//            if(pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//			}
//            if(rs != null)
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//		}
//            if(conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//			e.printStackTrace();
//				}
//       }
		return meetingRoom;
	}

	@Override
	public List<MeetingRoom> showAllMeetingRooms() {


		try {
			pstmt = conn.prepareStatement(viewAllRooms);
		    rs = pstmt.executeQuery(viewAllRooms);
			while (rs.next()) {
				/*using the below constructor only for implementing JDBC, 
				because my local DB has amenities in String Type : this needs to be deleted later
				when procedures/triggers will be implemented. 
				 */
				MeetingRoom meet = new MeetingRoom(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				roomList.add(meet);
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} 
		finally {
            if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
			}
            if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
		}
            if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
			e.printStackTrace();
				}
       }
		return roomList;
	}

	@Override
	public void updateMeetingRoomById(MeetingRoom meetingRoom) throws MeetingRoomDoesNotExistsException {

	}

}
