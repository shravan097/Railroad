import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

		ReservationQuery reservation = new ReservationQuery();

		List<Reservation>  result = reservation.getAllReservation();
		for( Reservation i: result)
			System.out.printf("%d %s %d\n",i.getReservation_id(),i.getReservation_date(),i.getPaying_passenger_id());

        // TESTING
//
//    			testConnection test = new testConnection();
    		     	MainGUI tp = new MainGUI();
    		        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		        tp.setVisible(true);
    }
       
}
