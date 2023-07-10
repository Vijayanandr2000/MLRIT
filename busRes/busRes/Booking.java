package busRes;

import java.sql.*;
import java.util.*;

public class Booking {
	String name;
	static int busNo;
	static String date;
	
	Booking(Scanner sc){
		System.out.println("Enter Passenger Name: ");
		name = sc.next();
		
		System.out.println("Enter Bus no: ");
		busNo = sc.nextInt();
		
		System.out.println("Enter Date in dd-mm-yyyy");
		date = sc.next();
		
	}
	
	public boolean isAvl() throws SQLException
	{
		int capacity = bus.getCapacity(busNo);
		Connection conn = DbConn.getConnection();
		
		String query = "select count(*) from bookings where busNo = ? and date = ?";
		
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setInt(1, busNo);
		pst.setString(2, date);
		
		
		
		ResultSet rs =  pst.executeQuery();
		rs.next();
		int booked = rs.getInt(1);
		return booked < capacity;
	}
	public static int addBooking(Booking booking) throws SQLException {
		Connection conn = DbConn.getConnection();
		String query = "insert into bookings (passengerName, busNo, date) values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(query);
		
		pst.setString(1, booking.name);
		pst.setInt(2, Booking.busNo);
		pst.setString(3, Booking.date);
		
		
		
		int row =  pst.executeUpdate();
		return row;
	}
}
