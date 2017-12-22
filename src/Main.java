import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

		TrainQuery available_train = new TrainQuery();
		List<Train>  result = available_train.getAllTrain("2017-11-13","BOS","NYP","MOR","W");

		for( Train i: result)
			System.out.printf("Train_ID: %d\t\t\tStart_Station: %s\t\t\tEnd_Station: %s\t\t\tTime_Of_Day: %s\n",
				 i.getTrain_id(),i.getStart_station(),i.getEnd_station(),i.getTime_of_day());

        // TESTING
        
//    			testConnection test = new testConnection();
//    		     GUI tp = new GUI();
//    		        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    		        tp.setVisible(true);
    }
       
}
