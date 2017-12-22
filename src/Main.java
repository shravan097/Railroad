import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

		ReservationQuery reservation = new ReservationQuery();
		reservation.make_reservation("Johnathon","Smith",9,"Visa",
				"4880090989788876","425 Hollywood Blvd Los Angeles,CA");

		List<Reservation>  result = reservation.getAllReservation();
		for( Reservation i: result)
			System.out.printf("%d %s %d\n",i.getReservation_id(),i.getReservation_date(),i.getPaying_passenger_id());

        // TESTING
//
//    			testConnection test = new testConnection();
    		     GUI tp = new GUI();
    		        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		        tp.setVisible(true);
    }
       
}
