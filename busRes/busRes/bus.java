package busRes;

import java.sql.*;

public class bus {
	public static void displayBuses() throws SQLException {
		Connection conn = DbConn.getConnection();
		Statement st = conn.createStatement();
		
		String query = "select * from buses";
		
		ResultSet rs =  st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(
					"Bus No: " + rs.getInt(1) + 
					" - " + 
							"AC : " + (rs.getBoolean(4) ? "Y" : "N")+ " - " + "Capacity: " + rs.getInt(3));
		}
	}
	public static int getCapacity(int busNo) throws SQLException {
		Connection conn = DbConn.getConnection();
		Statement st = conn.createStatement();
		
		String query = "select capacity from buses where id = "+busNo;
		
		ResultSet rs =  st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
