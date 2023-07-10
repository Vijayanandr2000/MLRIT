package busRes;

import java.sql.SQLException;
import java.util.*;

public class startBooking {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Welcome..!");
//		bus busDetail = new bus();
		
		bus.displayBuses();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 1 for booking 2 for existing..!");
			int userInput = sc.nextInt();
			if(userInput == 1) {
				Booking booking = new Booking(sc);
				boolean isAvl = booking.isAvl();
				System.out.println("Booked" + " -> " + isAvl);
				if(isAvl) {
					int row = booking.addBooking(booking);
					if(row > 0) {
						System.out.println("Booking Confirmed" + " " + booking.name);
					}else {
						System.out.println("Someting went wrong");
					}
				}else {
					System.out.println("Bus full book for other date");
				}
				
			}else if(userInput == 2) {
				break;
			}else {
				System.out.println("Idiot only give 1 or 2");
			}
		}
		sc.close();
	}

}
