/**
 * @author ShubhraBhuniaGhosh
 */
package com.hsbc.meets.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.meets.dao.MeetingRoomDao;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameAlreadyExistException;

public class MeetingRoomDbDaoImpl implements MeetingRoomDao{

	private static final String UPDATE_MEETING_ROOM_BY_ID_SQL = "UPDATE meetingroom SET name = ?, seating_capacity = ?, per_hour_cost = ? WHERE meetingroom_id = ?";
	/**
	 * Database credentials 
	 */
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";	
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/meetproject";

	private Connection con;


















	public MeetingRoomDbDaoImpl(){
		con = null;
		try
		{
			Class.forName(DRIVER_CLASS_NAME);
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	protected void finalize()  {
		//System.out.println("in distructor");
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}














	/**
	 * I am not implementing
	 */
	public void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException{}
	public List <MeetingRoom> displayMeetingRoom(){return null;}

	/**
	 *I am implementing it
	 */
	/**
	 *call to get the id because we cannot call by name and also change the name ad if we are taking all the 
	 *information from controller directly we are not sending the room id to the controller or service layer 
	 *for that matter
	 *  
	 */
	
	
	public int updateMeetingRoomById(MeetingRoom newMeetingRoom) throws MeetingRoomDoesNotExistsException, MeetingRoomNameAlreadyExistException{
		PreparedStatement stmt = null;
		int numberOfRowsUpdate  = -1;
		try {
			stmt = con.prepareStatement(UPDATE_MEETING_ROOM_BY_ID_SQL);
			stmt.setString(1, newMeetingRoom.getMeetingRoomName());
			stmt.setInt(2, newMeetingRoom.getSeatingCapacity());
			stmt.setInt(3, newMeetingRoom.getCreditsPerHour());
			stmt.setInt(4, newMeetingRoom.getMeetingRoomId());
			numberOfRowsUpdate = stmt.executeUpdate();
			if(numberOfRowsUpdate==0) {
				throw new MeetingRoomDoesNotExistsException();
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new MeetingRoomNameAlreadyExistException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRowsUpdate;
	}

	public int deleteAminitiesByMeetingRoomById(int meetingRoomId) {
		PreparedStatement stmt = null;
		int numberOfRowsUpdate  = -1;
		try {
			stmt = con.prepareStatement("DELETE FROM amenities WHERE meeting_room_id = ?");
			stmt.setInt(1,meetingRoomId);
			numberOfRowsUpdate = stmt.executeUpdate();
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return numberOfRowsUpdate;
	}
	
	public int insertAminitiesByMeetingRoomById(int meetingRoomId, String amenities) {
		PreparedStatement stmt = null;
		int numberOfRowsUpdate  = -1;
		try {
			stmt = con.prepareStatement("INSERT INTO meetproject.amenities (amenity_name,meeting_room_id) VALUES (?, ?)");
			stmt.setString(1,amenities);
			stmt.setInt(2, meetingRoomId);
			numberOfRowsUpdate = stmt.executeUpdate();
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return numberOfRowsUpdate;
	}














//	public int getRoomIdByMeetingRoomName(String meetingRoomName){
//		PreparedStatement stmt = null;
//		ResultSet resultSet = null;
//		int meetingRoomId = -1;
//		try {
//			stmt = con.prepareStatement("SELECT meetingroom_id FROM meetingroom WHERE name=?");
//			stmt.setString(1, meetingRoomName);
//			resultSet = stmt.executeQuery();
//			if(resultSet.next()) {
//				meetingRoomId = resultSet.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				if(resultSet!=null)
//				{
//					resultSet.close();
//				}
//
//				if(stmt != null)
//				{
//					stmt.close();
//				}
//			}
//			catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		}
//		return meetingRoomId;
//	}
















		public static void main(String[] args) throws MeetingRoomDoesNotExistsException {
//			ArrayList<String> arr = new  ArrayList<String>();
//			MeetingRoom newroom = new MeetingRoom(100, "something nice", 33, arr, 45, 5, 100);
//			
//			System.out.println(new MeetingRoomDbDaoImpl().updateMeetingRoomById(newroom));
			
//			System.out.println(new MeetingRoomDbDaoImpl().deleteAminitiesByMeetingRoomById(12));
			System.out.println(new MeetingRoomDbDaoImpl().insertAminitiesByMeetingRoomById(12, "Wifi connection"));
			System.out.println(new MeetingRoomDbDaoImpl().insertAminitiesByMeetingRoomById(12, "Whiteboard"));
			
		}
}
