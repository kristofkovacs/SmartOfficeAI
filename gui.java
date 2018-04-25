import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;

import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Term;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.text.DefaultCaret;


/** internal action that creates a simple GUI with two buttons that trigger AS plans */
class Gui{
	
	 private Env environment;
	 
	    public void setEnvironment(Env environment) {
	        this.environment = environment;
	    }
	
	JTextArea textArea;
	JTextField txtStandBy;
	JTextField txtOperating;
	JTextField txtClosed;
	JTextField txtClosed_1;
	JTextField textField;
    
	    public Gui(){
        
	        // get the window title
	        String title = "FireAlert GUI";
	        
	        // create the windows
	        JFrame frame;
	    	
	        
	        frame = new JFrame();
	        frame.setTitle(title);
			frame.setResizable(false);
			frame.setBounds(100, 100, 800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Room Control", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			frame.getContentPane().add(panel, BorderLayout.WEST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{232, 0};
			gbl_panel.rowHeights = new int[]{60, 0, 0, 132, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Room1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setToolTipText("");
			panel_3.setName("Room1");
			GridBagConstraints gbc_panel_3 = new GridBagConstraints();
			gbc_panel_3.insets = new Insets(0, 0, 5, 0);
			gbc_panel_3.anchor = GridBagConstraints.NORTHWEST;
			gbc_panel_3.gridx = 0;
			gbc_panel_3.gridy = 0;
			panel.add(panel_3, gbc_panel_3);
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{75, 56, 39, 25, 0};
			gbl_panel_3.rowHeights = new int[]{25, 0, 0};
			gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_3.setLayout(gbl_panel_3);
			
			JLabel lblTemperature = new JLabel("Temperature");
			GridBagConstraints gbc_lblTemperature = new GridBagConstraints();
			gbc_lblTemperature.anchor = GridBagConstraints.WEST;
			gbc_lblTemperature.insets = new Insets(0, 0, 5, 5);
			gbc_lblTemperature.gridx = 0;
			gbc_lblTemperature.gridy = 0;
			panel_3.add(lblTemperature, gbc_lblTemperature);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(25.0, 20.0, 100.0, 0.5));
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 0;
			panel_3.add(spinner, gbc_spinner);
			
			JLabel lblSmoke = new JLabel("Smoke");
			GridBagConstraints gbc_lblSmoke = new GridBagConstraints();
			gbc_lblSmoke.anchor = GridBagConstraints.WEST;
			gbc_lblSmoke.insets = new Insets(0, 0, 0, 5);
			gbc_lblSmoke.gridx = 0;
			gbc_lblSmoke.gridy = 1;
			panel_3.add(lblSmoke, gbc_lblSmoke);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxNewCheckBox.anchor = GridBagConstraints.NORTHWEST;
			gbc_chckbxNewCheckBox.gridx = 1;
			gbc_chckbxNewCheckBox.gridy = 1;
			panel_3.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
			
			JPanel panel_1 = new JPanel();
			panel_1.setToolTipText("");
			panel_1.setName("Room2");
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Room2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			panel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{75, 56, 39, 25, 0};
			gbl_panel_1.rowHeights = new int[]{25, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			JLabel label = new JLabel("Temperature");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			panel_1.add(label, gbc_label);
			
			JSpinner spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(25.0, 20.0, 100.0, 0.5));
			GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
			gbc_spinner_1.anchor = GridBagConstraints.WEST;
			gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_1.gridx = 1;
			gbc_spinner_1.gridy = 0;
			panel_1.add(spinner_1, gbc_spinner_1);
			
			JLabel label_1 = new JLabel("Smoke");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.WEST;
			gbc_label_1.insets = new Insets(0, 0, 0, 5);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 1;
			panel_1.add(label_1, gbc_label_1);
			
			JCheckBox checkBox = new JCheckBox("");
			GridBagConstraints gbc_checkBox = new GridBagConstraints();
			gbc_checkBox.anchor = GridBagConstraints.NORTHWEST;
			gbc_checkBox.insets = new Insets(0, 0, 0, 5);
			gbc_checkBox.gridx = 1;
			gbc_checkBox.gridy = 1;
			panel_1.add(checkBox, gbc_checkBox);
			
			JPanel panel_2 = new JPanel();
			panel_2.setToolTipText("");
			panel_2.setName("Room3");
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Room3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 0);
			gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
			gbc_panel_2.gridx = 0;
			gbc_panel_2.gridy = 2;
			panel.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{75, 56, 39, 25, 0};
			gbl_panel_2.rowHeights = new int[]{25, 0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			
			JLabel label_2 = new JLabel("Temperature");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.WEST;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 0;
			panel_2.add(label_2, gbc_label_2);
			
			JSpinner spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(25.0, 20.0, 100.0, 0.5));
			GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
			gbc_spinner_2.anchor = GridBagConstraints.WEST;
			gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_2.gridx = 1;
			gbc_spinner_2.gridy = 0;
			panel_2.add(spinner_2, gbc_spinner_2);
			
			JLabel label_3 = new JLabel("Smoke");
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.anchor = GridBagConstraints.WEST;
			gbc_label_3.insets = new Insets(0, 0, 0, 5);
			gbc_label_3.gridx = 0;
			gbc_label_3.gridy = 1;
			panel_2.add(label_3, gbc_label_3);
			
			JCheckBox checkBox_1 = new JCheckBox("");
			GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
			gbc_checkBox_1.anchor = GridBagConstraints.NORTHWEST;
			gbc_checkBox_1.insets = new Insets(0, 0, 0, 5);
			gbc_checkBox_1.gridx = 1;
			gbc_checkBox_1.gridy = 1;
			panel_2.add(checkBox_1, gbc_checkBox_1);
			
			JButton btnNewButton = new JButton("Refresh");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 3;
			panel.add(btnNewButton, gbc_btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Clear");
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_1.gridx = 0;
			gbc_btnNewButton_1.gridy = 4;
			panel.add(btnNewButton_1, gbc_btnNewButton_1);
			
			JSplitPane splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			frame.getContentPane().add(splitPane, BorderLayout.CENTER);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			splitPane.setRightComponent(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			DefaultCaret caret = (DefaultCaret)textArea.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "Effects", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane.setLeftComponent(panel_4);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_4.setLayout(gbl_panel_4);
			
			JLabel lblEmergencyCall = new JLabel("Emergency Call");
			GridBagConstraints gbc_lblEmergencyCall = new GridBagConstraints();
			gbc_lblEmergencyCall.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmergencyCall.gridx = 0;
			gbc_lblEmergencyCall.gridy = 0;
			panel_4.add(lblEmergencyCall, gbc_lblEmergencyCall);
			
			txtStandBy = new JTextField();
			txtStandBy.setEditable(false);
			txtStandBy.setText("Standing by");
			GridBagConstraints gbc_txtStandBy = new GridBagConstraints();
			gbc_txtStandBy.insets = new Insets(0, 0, 5, 5);
			gbc_txtStandBy.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStandBy.gridx = 1;
			gbc_txtStandBy.gridy = 0;
			panel_4.add(txtStandBy, gbc_txtStandBy);
			txtStandBy.setColumns(10);
			
			JLabel lblElevators = new JLabel("Elevators");
			GridBagConstraints gbc_lblElevators = new GridBagConstraints();
			gbc_lblElevators.insets = new Insets(0, 0, 5, 5);
			gbc_lblElevators.gridx = 2;
			gbc_lblElevators.gridy = 0;
			panel_4.add(lblElevators, gbc_lblElevators);
			
			txtOperating = new JTextField();
			txtOperating.setText("Operating");
			txtOperating.setEditable(false);
			GridBagConstraints gbc_txtOperating = new GridBagConstraints();
			gbc_txtOperating.insets = new Insets(0, 0, 5, 0);
			gbc_txtOperating.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOperating.gridx = 3;
			gbc_txtOperating.gridy = 0;
			panel_4.add(txtOperating, gbc_txtOperating);
			txtOperating.setColumns(10);
			
			JLabel lblEmergencyExits = new JLabel("Emergency Exits");
			GridBagConstraints gbc_lblEmergencyExits = new GridBagConstraints();
			gbc_lblEmergencyExits.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmergencyExits.gridx = 0;
			gbc_lblEmergencyExits.gridy = 1;
			panel_4.add(lblEmergencyExits, gbc_lblEmergencyExits);
			
			txtClosed = new JTextField();
			txtClosed.setEditable(false);
			txtClosed.setText("Manual operation");
			GridBagConstraints gbc_txtClosed = new GridBagConstraints();
			gbc_txtClosed.insets = new Insets(0, 0, 5, 5);
			gbc_txtClosed.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtClosed.gridx = 1;
			gbc_txtClosed.gridy = 1;
			panel_4.add(txtClosed, gbc_txtClosed);
			txtClosed.setColumns(10);
			
			JLabel lblParkingGate = new JLabel("Parking Gate");
			GridBagConstraints gbc_lblParkingGate = new GridBagConstraints();
			gbc_lblParkingGate.insets = new Insets(0, 0, 5, 5);
			gbc_lblParkingGate.gridx = 2;
			gbc_lblParkingGate.gridy = 1;
			panel_4.add(lblParkingGate, gbc_lblParkingGate);
			
			txtClosed_1 = new JTextField();
			txtClosed_1.setEditable(false);
			txtClosed_1.setText("Manual Operation");
			GridBagConstraints gbc_txtClosed_1 = new GridBagConstraints();
			gbc_txtClosed_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtClosed_1.insets = new Insets(0, 0, 5, 0);
			gbc_txtClosed_1.gridx = 3;
			gbc_txtClosed_1.gridy = 1;
			panel_4.add(txtClosed_1, gbc_txtClosed_1);
			txtClosed_1.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Emergency Speakers");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			panel_4.add(lblNewLabel, gbc_lblNewLabel);
			
			textField = new JTextField();
			textField.setEditable(false);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridwidth = 3;
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			panel_4.add(textField, gbc_textField);
			textField.setColumns(10);
	        
			frame.setVisible(true);
			
	        // add the event listeners
			btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // creates a new event +!run so that the agent can react to the button
				   environment.refreshSensors(spinner.getValue(),chckbxNewCheckBox.isSelected(), spinner_1.getValue(),checkBox.isSelected(), spinner_2.getValue(),checkBox_1.isSelected());
				}
	        });
			
			btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // creates a new event +!run so that the agent can react to the button
				   textArea.setText(null);
				}
	        });
    }
	
	public void writeConsole(String msg){
		textArea.append(msg+"\n");
	}
	
	public void emergencyCall(String operation){
		switch (operation){
			case "firefighters" : txtStandBy.setText("Calling firefighters");
								  break;
			case "police" : txtStandBy.setText("Calling police");
							break;
			case "ambulance" : txtStandBy.setText("Calling ambulance");
							   break;
			default : txtStandBy.setText("Standing by");
					  break;
		}
	}
	
	public void emergencyElevator(boolean state){
		if(state)
			txtOperating.setText("Operating");
		else 
			txtOperating.setText("Out of order");
		
	}
	
	public void emergencyExits(String state){
		switch (state){
			case "open" : txtClosed.setText("Forced open");
								  break;
			case "close" : txtClosed.setText("Forced close");
							break;
			case "manual" : 
			default : txtClosed.setText("Manual operation");
					  break;
		}
	}
	
	public void emergencyGates(String state){
		switch (state){
			case "open" : txtClosed_1.setText("Forced open");
								  break;
			case "close" : txtClosed_1.setText("Forced close");
							break;
			case "manual" : 
			default : txtClosed_1.setText("Manual operation");
					  break;
		}
	}
	
	public void emergencySpeakers(String speach){
		textField.setText(speach);
	}
	
}