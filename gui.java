import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GUI implements ActionListener {
	public static final String windowTitle = "Intelligens Elosztott Rendszerek - 2018";
	public static final String roomControlPanelTitle = "Szerverszoba szenzor kezelőpanel";
	public static final String roomControlSubPanelTitle = "Szerverszoba ";
	public static final String infoPanelTitle = "Rendszer információk";
	public static final String consolePanelTitle = "Rendszer konzol";
	public static final int numberOfAgents = 4;

	Window window;
	
	Env environment;

	public GUI(Env env) {
		window = new Window(this);
		
		environment = env;
	}

	// Szenzor adatok küldése gomb eseménykezelő
	@Override
	public void actionPerformed(ActionEvent e) {
		env.updateSensorStates(window.getRoomControls());
	}

	public void log(String str) {
		String timeStamp = new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime());

		String logStr = " [ " + timeStamp.toString() + " ] " + " - " + str;
		window.log(logStr);
	}
	
	public List<RoomControl> getRoomControls() {
		return window.getRoomControls();
	}
	
	public List<AgentInfo> getAgentOutputs(){
		return window.getRoomOutputs();
	}

	// for test purposes
	public static void main(String[] args) {
		GUI gui = new GUI();
	}

}
