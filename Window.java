import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.BoxLayout;

public class Window extends JFrame {
	
	private RoomControlMainPanel roomControlMainPanel;
	private ConsolePanel consolePanel;
	private AgentInfoMainPanel agentInfoMainPanel;

	public Window(GUI gui) {
		super();
		setTitle(GUI.windowTitle);
		setResizable(true);
		setBounds(20, 20, 1250, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setLayout(new FlowLayout());
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		roomControlMainPanel = new RoomControlMainPanel(gui);
		consolePanel = new ConsolePanel();
		agentInfoMainPanel = new AgentInfoMainPanel();

		
		
		add(roomControlMainPanel);
		add(consolePanel);
		add(agentInfoMainPanel);
		
//		JScrollPane scroll = new JScrollPane (agentInfoMainPanel, 
//				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		add(scroll);
		
		setVisible(true);
	}

	public void log(String str) {
		consolePanel.log(str);
		
	}

	public List<RoomControl> getRoomControls() {
		return roomControlMainPanel.getRoomControls();		
	}
	
	public List<AgentInfo> getRoomOutputs(){
		return agentInfoMainPanel.getAgentInfoPanels();
	}
}
