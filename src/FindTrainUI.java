import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
eclipse.buildId=4.7.1.M20171009-0410
java.version=9.0.1
java.vendor=Oracle Corporation
BootLoader constants: OS=macosx, ARCH=x86_64, WS=cocoa, NL=en_US
Framework arguments:  -product org.eclipse.epp.package.java.product -keyring /Users/Jake/.eclipse_keyring
Command-line arguments:  -os macosx -ws cocoa -arch x86_64 -product org.eclipse.epp.package.java.product -keyring /Users/Jake/.eclipse_keyring

org.eclipse.core.resources
Warning
Fri Dec 22 12:44:21 EST 2017
The project description file (.project) for 'RAILROAD' was missing.  This file contains important information about the project.  A new project description file has been created, but some information about the project may have been lost.

public class FindTrainUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public FindTrainUI() {
		setLayout(null);
		
		JComboBox setOrigin = new JComboBox();
		setOrigin.setBounds(19, 34, 207, 27);
		add(setOrigin);
		
		JComboBox setDestination = new JComboBox();
		setDestination.setBounds(19, 84, 207, 27);
		add(setDestination);
		
		JComboBox setTravelers = new JComboBox();
		setTravelers.setBounds(19, 136, 133, 27);
		add(setTravelers);
		
		JComboBox setMonth = new JComboBox();
		setMonth.setBounds(19, 185, 64, 27);
		add(setMonth);
		
		JComboBox setDay = new JComboBox();
		setDay.setBounds(95, 185, 64, 27);
		add(setDay);
		
		JComboBox setYear = new JComboBox();
		setYear.setBounds(171, 185, 55, 27);
		add(setYear);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(19, 230, 207, 29);
		add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Select Origin Station");
		lblNewLabel.setBounds(22, 17, 204, 16);
		add(lblNewLabel);
		
		JLabel lblSelectDestinationStation = new JLabel("Select Destination Station");
		lblSelectDestinationStation.setBounds(22, 66, 204, 16);
		add(lblSelectDestinationStation);
		
		JLabel lblSelectTravelers = new JLabel("Select Travelers");
		lblSelectTravelers.setBounds(22, 118, 204, 16);
		add(lblSelectTravelers);
		
		JLabel lblMm = new JLabel("Select Travel Date");
		lblMm.setBounds(22, 168, 204, 16);
		add(lblMm);
		
		JList avail_trains = new JList();
		avail_trains.setBounds(248, 38, 232, 166);
		add(avail_trains);
		
		JLabel lblNewLabel_1 = new JLabel("Available Trains");
		lblNewLabel_1.setBounds(312, 17, 105, 16);
		add(lblNewLabel_1);
		
		JButton btnSelect = new JButton("Clear Selection");
		btnSelect.setBounds(257, 248, 207, 29);
		add(btnSelect);
		
		JButton btnClear = new JButton("Make Selection");
		btnClear.setBounds(258, 216, 207, 29);
		add(btnClear);

	}
}
