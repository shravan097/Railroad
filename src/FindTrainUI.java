import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class FindTrainUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public FindTrainUI() {
		setLayout(null);
		
		JComboBox setOrigin = new JComboBox();
		setOrigin.setBounds(19, 34, 207, 27);


		StationQuery station_query = new StationQuery();
		List<Station> allStation = station_query.getAllStation();
		for (Station i : allStation)
			setOrigin.addItem(i.getStation_name());
		add(setOrigin);



		
		JComboBox setDestination = new JComboBox();
		setDestination.setBounds(19, 84, 207, 27);
		for (Station i : allStation)
			setDestination.addItem(i.getStation_name());
		add(setDestination);

		// Travel Up to 10 People
		JComboBox setTravelers = new JComboBox();
		setTravelers.setBounds(19, 136, 133, 27);
		for( int i = 1; i< 11; ++i)
			setTravelers.addItem(i);
		add(setTravelers);

		TrainQuery trainQuery = new TrainQuery();
		DefaultListModel<String> allStationModel= new DefaultListModel();
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(19, 230, 207, 29);

		
		JLabel lblNewLabel = new JLabel("Select Origin Station");
		lblNewLabel.setBounds(22, 17, 204, 16);
		add(lblNewLabel);
		
		JLabel lblSelectDestinationStation = new JLabel("Select Destination Station");
		lblSelectDestinationStation.setBounds(22, 66, 204, 16);
		add(lblSelectDestinationStation);
		
		JLabel lblSelectTravelers = new JLabel("Select Travelers");
		lblSelectTravelers.setBounds(22, 118, 204, 16);
		add(lblSelectTravelers);
		


		JLabel lblSelectDate = new JLabel("Enter Date (YYYY-MM-DD)");
		lblSelectDate.setBounds(22, 168, 204, 16);
		add(lblSelectDate);
		JTextField date = new JTextField(10);
		date.setBounds(20,185,134,26);
		add(date);



		JList avail_trains = new JList(allStationModel);
		JScrollPane avail_train_scroll = new JScrollPane(avail_trains);
		avail_train_scroll.setBounds(248, 38, 232, 166);
		add(avail_train_scroll);
		
		JLabel lblNewLabel_1 = new JLabel("Available Trains");
		lblNewLabel_1.setBounds(312, 17, 105, 16);
		add(lblNewLabel_1);
		
		JButton btnSelect = new JButton("Clear Selection");
		btnSelect.setBounds(257, 248, 207, 29);
		add(btnSelect);
		
		JButton btnClear = new JButton("Make Selection");
		btnClear.setBounds(258, 216, 207, 29);




		//Make Selection Handler
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String train_id = (String)avail_trains.getSelectedValue();
				MainGUI.selectedTrainString = train_id;
				String [] selected = train_id.split("[\t]");
				MainGUI.selectedTrain.setTrain_id(Integer.parseInt(selected[0]));
				String resString = String.format("Train ID:\t\t%s\nStart Station:\t\t%s\nEnd Station:\t\t%s\n Date:\t\t%s\n",selected[0],selected[1],selected[2],selected[4]);
				if(MakeResUI.textPane != null) MakeResUI.textPane.setText(resString);
				MainGUI.jtp.setSelectedIndex(1);
			}
		});
		add(btnClear);



		//Search Button Handler
		btnSearch.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						if(lblSelectDate.getText()=="" || lblSelectDate.getText()==" " ) System.exit(1);
						String converted_station1 = station_query.get_station_symbol((String)setOrigin.getSelectedItem());
						String converted_station2 = station_query.get_station_symbol((String)setDestination.getSelectedItem());
						MainGUI.selectedTrain.setStart_station(converted_station1);
						MainGUI.selectedTrain.setEnd_station(converted_station2);
						MainGUI.selectedTrain.setTime_of_day("MOR");
						List<Train> avail_train = trainQuery.getAllTrain(
								date.getText(),converted_station1,
								converted_station2,"MOR",
								"M"
						);
						allStationModel.clear();
						for (Train i : avail_train) {
							String temp = String.format("%d\t%s\t%s\t%s\t%s\n",
									i.getTrain_id(), i.getStart_station(), i.getEnd_station(), i.getTime_of_day(),
									i.getTravel_date());

							allStationModel.addElement(temp);
						}
						revalidate();
						repaint();
					}
				}
		);
		add(btnSearch);

	}
}
