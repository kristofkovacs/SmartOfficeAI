import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgentInfoPanel extends JPanel implements AgentInfo {
	private static final String defaultEmergencyMessage = "Nincs értesítés";
	
	private static final String defaultAlarmMessage = "Nincs riasztás";
	private static final String alarmTurnedOn = "Élesítve";
	private static final String alarmTurnedOff = "Kikapcsolva";
	private static final int defaultAlarmCounterValue = 30;
	
	private static final String defaultBackupMessage = "Nincs folyamatban";
	private static final String inProgressMessage = "Folyamatban...";
	private static final String sendingDataMessage = "Adatok küldése...";
	private static final String receivingDataMessage = "Adatok fogadása...";
	
	private static final String doorsOpenedMessage = "Nyitva";
	private static final String doorsClosedMessage = "Zárva";
	
	private int alarmCounter = defaultAlarmCounterValue;

	private JTextField fireFightersTF;
	private JTextField PoliceTF;
	private JTextField alarmStateTF;
	private JTextField alarmCounterTF;
	private JTextField alarmMessageTF;
	private JTextField backupTF;
	private JTextField DoorsTF;
	
	public AgentInfoPanel(int roomNumber) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		final String panelTitle = GUI.roomControlSubPanelTitle + " " + roomNumber;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), panelTitle, TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		
//		setPreferredSize(new Dimension(100, 50));
		
		fireFightersTF = new JTextField();
		createSubPanelWithLabel("Tűzoltók értesítése", fireFightersTF, defaultEmergencyMessage, 10);

		PoliceTF = new JTextField();
		createSubPanelWithLabel("Rendőrség értesítése", PoliceTF, defaultEmergencyMessage, 10);
		
		backupTF = new JTextField();
		createSubPanelWithLabel("Biztonsági mentés", backupTF, defaultBackupMessage, 10);
		
		DoorsTF = new JTextField();
		createSubPanelWithLabel("Ajtók állapota", DoorsTF, doorsOpenedMessage, 10);
		
		alarmStateTF = new JTextField();
		createSubPanelWithLabel("Riasztó állapota", alarmStateTF, alarmTurnedOff, 10);
		
		alarmCounterTF = new JTextField();
		createSubPanelWithLabel("Riasztó számláló", alarmCounterTF, String.valueOf(alarmCounter), 10);

		alarmMessageTF = new JTextField();
		createSubPanelWithLabel("Riasztó üzenet", alarmMessageTF, defaultAlarmMessage, 33);
		
	}

	private void createSubPanelWithLabel(String labelStr, JTextField tf, String defaultTFText, int tfWidth) {
		JPanel subPanel = new JPanel();
		JLabel label = new JLabel(labelStr);
		label.setPreferredSize(new Dimension(125, 20));
		tf.setEditable(false);
		tf.setText(defaultTFText);
		tf.setColumns(tfWidth);

		subPanel.add(label);
		subPanel.add(tf);
		add(subPanel);
	}
	
	public void decreaseAlarmTimer() {
		if(alarmCounter > 0)
			alarmCounter--;
		alarmCounterTF.setText(String.valueOf(alarmCounter));
	}
	
	public boolean isAlarmCounterReachedZero() {
		return alarmCounter == 0;
	}
	
	public void activateAlarm() {
		alarmCounter = defaultAlarmCounterValue;
		alarmCounterTF.setText(String.valueOf(alarmCounter));
		
		alarmStateTF.setText(alarmTurnedOn);
	}
	
	public void deactivateAlarm() {
		alarmCounter = defaultAlarmCounterValue;
		alarmCounterTF.setText(String.valueOf(alarmCounter));
		
		alarmStateTF.setText(alarmTurnedOff);
	}

	public void setAlarm(String message) {
		if (message == null)
			alarmMessageTF.setText(defaultAlarmMessage);
		else
			alarmMessageTF.setText("" + message);
	}

	public void callFireFighers(boolean value) {
		if (value)
			fireFightersTF.setText(inProgressMessage);
		else
			fireFightersTF.setText(defaultEmergencyMessage);
	}

	public void callPolice(boolean value) {
		if (value)
			PoliceTF.setText(inProgressMessage);
		else
			PoliceTF.setText(defaultEmergencyMessage);
	}

	public void closeDoors() {
		DoorsTF.setText(doorsClosedMessage);
	}
	
	public void openDoors() {
		DoorsTF.setText(doorsOpenedMessage);
	}

	public void sendBackupData() {
		backupTF.setText(sendingDataMessage);
	}
	
	public void receiveBackupData() {
		backupTF.setText(receivingDataMessage);
	}
	
	public void stopBackup() {
		backupTF.setText(defaultBackupMessage);
	}

}

interface AgentInfo {
	public void decreaseAlarmTimer();	
	public boolean isAlarmCounterReachedZero();	
	public void activateAlarm();
	public void deactivateAlarm();
	public void setAlarm(String message);

	public void callFireFighers(boolean value);
	public void callPolice(boolean value);

	public void closeDoors();
	public void openDoors();

	public void sendBackupData();	
	public void receiveBackupData();
	public void stopBackup();
}
