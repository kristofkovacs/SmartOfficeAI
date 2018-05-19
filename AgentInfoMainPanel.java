import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class AgentInfoMainPanel extends JPanel{

	private List<AgentInfo> agentInfoPanels;
	
	public AgentInfoMainPanel() {
		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), GUI.infoPanelTitle, TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		setPreferredSize(new Dimension(480, 450));
		
		agentInfoPanels = new ArrayList<>(GUI.numberOfAgents);
		
		for(int i = 0; i < GUI.numberOfAgents; i++) {
			final AgentInfoPanel agent = new AgentInfoPanel(i);
			add(agent);
			agentInfoPanels.add(agent);
		}
	}
	
	public List<AgentInfo> getAgentInfoPanels(){
		return agentInfoPanels;
	}
}
