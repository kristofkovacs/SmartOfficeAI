import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomControlMainPanel extends JPanel {
	
	private static final String clearFieldsStr = "Mezők törlése";
	private static final String sendSensorDataStr = "Szenzor adatok küldése";
	
	private List<RoomControl> rooms;

	public RoomControlMainPanel(GUI gui) {
		super(new GridLayout(5, 1, 0, 0), true);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), GUI.roomControlPanelTitle,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		rooms = new LinkedList<>();
		
		for(int i = 0; i < 4; i++) {
			final RoomControlPanel room = new RoomControlPanel(i);
			add(room); //add to panel
			rooms.add(room);//add to list
		}
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel);
		
		JButton sendSensorDataBtn = new JButton(sendSensorDataStr);
		sendSensorDataBtn.addActionListener(gui);
		buttonPanel.add(sendSensorDataBtn);
		
		JButton clearFieldsBtn = new JButton(clearFieldsStr);
		clearFieldsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (RoomControl room : rooms) {
					((RoomControlPanel)room).clearFields();
				}
			}
		});
		buttonPanel.add(clearFieldsBtn);
	}
	
	public List<RoomControl> getRooms(){
		return rooms;
	}

}
