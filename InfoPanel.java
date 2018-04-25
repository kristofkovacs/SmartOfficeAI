import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel {
	private static final String defaultEmergencyMessage = "Nincs értesítés";
	private static final String defaultAlarmMessage = "Nincs riasztás";
	private static final String defaultBackupMessage = "Nincs folyamatban";
	private static final String inProgressMessage = "Folyamatban...";
	
	private JPanel systemInformationPanel;
	private JPanel ConsolePanel;
	private JTextArea console;
	private JTextField fireFightersTF;
	private JTextField PoliceTF;
	private JTextField alarmMessageTF;
	private JTextField backupTF;

	public InfoPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		initSystemInformationPanel();		
		initConsolePanel();
	}

	private void initConsolePanel() {
		ConsolePanel = new JPanel();
		ConsolePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), GUI.consolePanelTitle,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(ConsolePanel);

		console = new JTextArea();
		console.setRows(20);
		console.setColumns(50);
		ConsolePanel.add(console);
		
		JScrollPane scroll = new JScrollPane (console, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ConsolePanel.add(scroll);
	}

	private void initSystemInformationPanel() {
		systemInformationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		systemInformationPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				GUI.infoPanelTitle, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(systemInformationPanel);
		
		fireFightersTF = new JTextField();
		createSubPanelWithLabel("Tűzoltók értesítése", fireFightersTF, defaultEmergencyMessage);
		
		PoliceTF = new JTextField();
		createSubPanelWithLabel("Rendőrség értesítése", PoliceTF, defaultEmergencyMessage);
		
		alarmMessageTF = new JTextField();
		createSubPanelWithLabel("Riasztó állapota", alarmMessageTF, defaultAlarmMessage);
		
		backupTF = new JTextField();
		createSubPanelWithLabel("Biztonsági mentés", backupTF, defaultBackupMessage);
	}

	private void createSubPanelWithLabel(String labelStr, JTextField tf, String defaultTFText) {
		JPanel subPanel = new JPanel();
		JLabel label = new JLabel(labelStr);
		label.setPreferredSize(new Dimension(150, 25));
		tf.setEditable(false);
		tf.setText(defaultTFText);
		tf.setColumns(20);
		
		subPanel.add(label);
		subPanel.add(tf);
		systemInformationPanel.add(subPanel);
	}

	public void log(String str) {
		console.append(str + "\n");
	}

	public void setAlarm(String message) {
		if(message == null)
			alarmMessageTF.setText(defaultAlarmMessage);
		else
			alarmMessageTF.setText("" + message);
	}

	public void callFireFighers(boolean value) {
		if(value)
			fireFightersTF.setText(inProgressMessage);
		else
			fireFightersTF.setText(defaultEmergencyMessage);		
	}

	public void callPolice(boolean value) {
		if(value)
			PoliceTF.setText(inProgressMessage);
		else
			PoliceTF.setText(defaultEmergencyMessage);		
	}

	public void closeDoors(int roomNumber, boolean value) {
		//TODO ehhez majd lehet, hogy kell valami mező a felületen
	}

	public void startBackup(int fromRoom, Object front, boolean value) {
		if(value)
			backupTF.setText(inProgressMessage);
		else
			backupTF.setText(defaultBackupMessage);		
		
	}
	
	


}
