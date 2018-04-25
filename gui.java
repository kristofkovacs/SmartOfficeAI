import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

public class GUI implements ActionListener {
	public static final String windowTitle = "Intelligens Elosztott Rendszerek - 2018";
	public static final String roomControlPanelTitle = "Szerverszoba szenzor kezelőpanel";
	public static final String roomControlSubPanelTitle = "Szerverszoba ";
	public static final String infoPanelTitle = "Rendszer információk";
	public static final String consolePanelTitle = "Rendszer konzol";

	Window window;

	public GUI() {
		window = new Window(this);
	}

	// Szenzor adatok küldése gomb eseménykezelő
	@Override
	public void actionPerformed(ActionEvent e) {
		window.getRooms();
		// TODO send data to env

	}

	public void log(String str) {
		String timeStamp = new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime());

		String logStr = " [ " + timeStamp.toString() + " ] " + " - " + str;
		window.log(logStr);
	}

	public void turnOnAlarm(String message) {
		window.setAlarm(message);
	}

	public void turnOffAlarm() {
		window.setAlarm(null);
	}

	public void callFireFighters() {
		window.callFireFighers(true);
	}

	public void stopCallingFireFighters() {
		window.callFireFighers(false);
	}

	public void callPolice() {
		window.callPolice(true);
	}

	public void stopCallingPolice() {
		window.callPolice(false);
	}

	public void closeDoors(int roomNumber) {
		window.closeDoors(roomNumber, true);
	}

	public void openDoors(int roomNumber) {
		window.closeDoors(roomNumber, false);
	}

	public void startingBackup(int fromRoom, int toRoom) {
		window.startBackup(fromRoom, toRoom, true);
	}

	public void backupFinished(int fromRoom, int toRoom) {
		window.startBackup(fromRoom, toRoom, false);
	}

	// for test purposes
	public static void main(String[] args) {
		GUI gui = new GUI();
	}

}
