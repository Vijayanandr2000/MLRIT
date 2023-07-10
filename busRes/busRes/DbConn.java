package busRes;

import java.sql.*;

public class DbConn {
	private static final String url = "jdbc:mysql://localhost:3306/busreservation";
	private static final String uName = "root";
	private static final String pWord = "Qotu3350@";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, uName, pWord);
	}
}
