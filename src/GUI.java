import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
 
public class GUI extends JFrame {
	public GUI() {
         
        setTitle("Tabbed Pane");
        setSize(573,514);
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        JLabel label3 = new JLabel();
        label3.setText("You are in area of Tab3");
        jp2.add(label2);
        jp3.add(label3);
        JPanel jp1 = new JPanel();
        jtp.addTab("New tab", null, jp1, null);
        JLabel label1 = new JLabel();
        label1.setBounds(197, 6, 167, 16);
        label1.setText("Look For Available Trains");
        jp1.setLayout(null);
        jp1.add(label1);
        
        JLabel lblNewLabel = new JLabel("Select Starting Station");
        lblNewLabel.setBounds(88, 34, 153, 16);
        jp1.add(lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(88, 46, 382, 48);
        jp1.add(comboBox);
        
        JLabel lblSelectEndingStation = new JLabel("Select Ending Station");
        lblSelectEndingStation.setBounds(88, 92, 153, 16);
        jp1.add(lblSelectEndingStation);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(88, 102, 382, 48);
        jp1.add(comboBox_1);
        
        JLabel lblSelectTravelers = new JLabel("Select Travelers");
        lblSelectTravelers.setBounds(88, 149, 153, 16);
        jp1.add(lblSelectTravelers);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBounds(88, 159, 110, 48);
        jp1.add(comboBox_2);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Book Roundtrip Fare");
        chckbxNewCheckBox.setBounds(225, 170, 197, 23);
        jp1.add(chckbxNewCheckBox);
        
        JLabel lblSelectDate = new JLabel("Select Date");
        lblSelectDate.setBounds(88, 205, 153, 16);
        jp1.add(lblSelectDate);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(98, 222, 34, 26);
        jp1.add(spinner);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setBounds(139, 222, 34, 26);
        jp1.add(spinner_1);
        
        JSpinner spinner_2 = new JSpinner();
        spinner_2.setBounds(174, 222, 34, 26);
        jp1.add(spinner_2);
        
        JList list = new JList();
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"value1|time|duration|a|b|available seats [] | $$", "value1|time|duration|a|b|available seats [] | $$ ", "value1|time|duration|a|b|available seats [] | $$"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        list.setBounds(63, 260, 432, 125);
        jp1.add(list);
        
        JButton btnNewButton = new JButton("Make Selection");
        btnNewButton.setBounds(56, 397, 142, 29);
        jp1.add(btnNewButton);
        
        JButton btnClearSelection = new JButton("Clear Selection");
        btnClearSelection.setBounds(210, 397, 142, 29);
        jp1.add(btnClearSelection);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(364, 397, 142, 29);
        jp1.add(btnRefresh);
        jtp.addTab("Tab2", jp2);
        jtp.addTab("Tab3",  jp3);
         
    }
}