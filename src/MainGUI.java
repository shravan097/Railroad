import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

public class MainGUI extends JFrame {
	
	public MainGUI() {
		setTitle("Tabbed Pane");
		setSize(573,514);
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		FindTrainUI panel1 = new FindTrainUI();
		MakeResUI panel2 = new MakeResUI();
		LookupResUI panel3 = new LookupResUI();
		
		jtp.addTab("Find Trains", null, panel1, null);
		jtp.addTab("Make Reservation", null, panel2, null);
		jtp.addTab("Look Up Reservation", null, panel3, null);


	}
}