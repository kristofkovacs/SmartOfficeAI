import javax.swing.JFrame;

import java.util.List;

import javax.swing.BoxLayout;

public class Window extends JFrame {
	
	private RoomControlMainPanel roomControlMainPanel;
	private InfoPanel infoPanel;

	public Window(GUI gui) {
		super();
		setTitle(GUI.windowTitle);
		setResizable(true);
		setBounds(50, 50, 1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		roomControlMainPanel = new RoomControlMainPanel(gui);
		infoPanel = new InfoPanel();
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		add(roomControlMainPanel);
		add(infoPanel);
		
		setVisible(true);
	}

	public void log(String str) {
		infoPanel.log(str);
		
	}

	public List<RoomControl> getRooms() {
		return roomControlMainPanel.getRooms();		
	}

	public void setAlarm(String message) {
		infoPanel.setAlarm(message);		
	}


	public void callFireFighers(boolean value) {
		infoPanel.callFireFighers(value);		
	}

	public void callPolice(boolean value) {
		infoPanel.callPolice(value);
		
	}

	public void closeDoors(int roomNumber, boolean value) {
		infoPanel.closeDoors(roomNumber, value);
	}

	public void startBackup(int fromRoom, int toRoom, boolean value) {
		infoPanel.startBackup(fromRoom, toRoom, value);
	}
}
