package demp_project;
import java.sql.*;

public class demo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			
			commit();
		
		

	}
	public static void read() throws SQLException {
System.out.println("hello world");
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String uName = "root";
		String pWord = "Qotu3350@";
		
		Connection conn = DriverManager.getConnection(url, uName, pWord);
		
		Statement st = conn.createStatement();
		
		String query = "insert into students (name,dept) values ('anand','ECE')";
		
		int row = st.executeUpdate(query);
		
		if(row == 0) {
			System.out.println("Something went wrong");
			return;
		}
		
		String getQ = "select * from students";
		
		ResultSet rs =  st.executeQuery(getQ);
		
		while(rs.next()) {
		
		System.out.println("Id is "+rs.getInt(1));
		System.out.println("Name is "+rs.getString(2));
		System.out.println("Dept is "+rs.getString(3));
		}	
	}
	public static void insert() throws SQLException {
		System.out.println("hello world");
				
				String url = "jdbc:mysql://localhost:3306/demo";
				String uName = "root";
				String pWord = "Qotu3350@";
				
				Connection conn = DriverManager.getConnection(url, uName, pWord);
				String query = "insert into students (name,dept) values (?,?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				String name = "kishore";
				String dept = "CSE";
				
				pst.setString(1, name);
				pst.setString(2, dept);
				
				pst.executeUpdate();
				
			}
	public static void sp() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String uName = "root";
		String pWord = "Qotu3350@";
		
		Connection conn = DriverManager.getConnection(url, uName, pWord);
		CallableStatement cst = conn.prepareCall("{call getStudent()}");
		
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Id is "+rs.getInt(1));
			System.out.println("Name is "+rs.getString(2));
			System.out.println("Dept is "+rs.getString(3));
			}	
	}
	public static void commit() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo";
		String uName = "root";
		String pWord = "Qotu3350@";
		
		Connection conn = DriverManager.getConnection(url, uName, pWord);
		conn.setAutoCommit(false);
		Statement st = conn.createStatement();
		
		String query1 = "update students set dept = 'abcd' where id=3";
		String query2 = "update students set dept = 'abcd' where id=4";
		
		
		int rows1 = st.executeUpdate(query1);
		System.out.println("Rows affected " + rows1);
		
		int rows2 = st.executeUpdate(query2);
		System.out.println("Rows affected " + rows2);
		if(rows1 > 0 && rows2 > 0) {
			conn.commit();
		}
		
	}


}
