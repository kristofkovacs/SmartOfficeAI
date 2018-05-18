import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgentInfoPanel extends JPanel implements AgentInfo {
	private static final String defaultEmergencyMessage = "Nincs ertesites";
	
	private static final String defaultAlarmMessage = " ";
	private static final String alarmTurnedOn = "Elesitve";
	private static final String alarmTurnedOff = "Kikapcsolva";
	private static final int defaultAlarmCounterValue = 30;
	
	private static final String defaultBackupMessage = "Nincs folyamatban";
	private static final String inProgressMessage = "Folyamatban...";
	private static final String sendingDataMessage = "Adatok kuldese...";
	private static final String serversTurnedOn = "Futnak";
	private static final String serversTurnedOff = "Kikapcsolva";
	
	private static final String doorsOpenedMessage = "Nyitva";
	private static final String doorsClosedMessage = "Zarva";
	
	private int alarmCounter = defaultAlarmCounterValue;

	private JTextField fireFightersTF;
	private JTextField PoliceTF;
	private JTextField alarmStateTF;
	private JTextField alarmCounterTF;
	private JTextField alarmMessageTF;
	private JTextField serversState;
	private JTextField DoorsTF;
	
	public AgentInfoPanel(int roomNumber) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));

		final String panelTitle = GUI.roomControlSubPanelTitle + " " + roomNumber;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), panelTitle, TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		
		fireFightersTF = new JTextField();
		createSubPanelWithLabel("Tuzoltok ertesitese", fireFightersTF, defaultEmergencyMessage, 10);

		PoliceTF = new JTextField();
		createSubPanelWithLabel("Rendorseg ertesitese", PoliceTF, defaultEmergencyMessage, 10);
		
		serversState = new JTextField();
		createSubPanelWithLabel("Szerverek allapota", serversState, serversTurnedOn, 10);
		
		DoorsTF = new JTextField();
		createSubPanelWithLabel("Ajtok allapota", DoorsTF, doorsOpenedMessage, 10);
		
		alarmStateTF = new JTextField();
		createSubPanelWithLabel("Riaszto allapota", alarmStateTF, alarmTurnedOff, 10);
		
		alarmCounterTF = new JTextField();
		createSubPanelWithLabel("Riaszto szamlalo", alarmCounterTF, String.valueOf(alarmCounter), 10);

		alarmMessageTF = new JTextField();
		createSubPanelWithLabel("Riaszto uzenet", alarmMessageTF, defaultAlarmMessage, 33);
		
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
	
	public void resetAlarmCounter(){
		alarmCounter = defaultAlarmCounterValue;
	}
	
	public void activateAlarm() {		
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
		serversState.setText(sendingDataMessage);
	}
	
	public void stopBackup() {
		serversState.setText(defaultBackupMessage);
	}
	
	public void startServers(){
		serversState.setText(serversTurnedOn);
	}

	public void stopServers(){
		serversState.setText(serversTurnedOff);
	}

}

interface AgentInfo {
	public void decreaseAlarmTimer();	
	public void resetAlarmCounter();
	public boolean isAlarmCounterReachedZero();	
	public void activateAlarm();
	public void deactivateAlarm();
	public void setAlarm(String message);

	public void callFireFighers(boolean value);
	public void callPolice(boolean value);

	public void closeDoors();
	public void openDoors();

	public void sendBackupData();	
	public void stopBackup();
	public void startServers();
	public void stopServers();
}
