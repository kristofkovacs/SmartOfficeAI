import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class ConsolePanel extends JPanel {

	private JTextArea console;

	public ConsolePanel() {
		super(new FlowLayout());
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), GUI.consolePanelTitle,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		setPreferredSize(new Dimension(400, 600));
		
		console = new JTextArea(37, 35);
		//console.setPreferredSize(new Dimension(300,600));
		console.setEditable(false);
//		console.setRows(20);
//		console.setColumns(35);
		//add(console);
		
		JScrollPane scroll = new JScrollPane (console, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setWheelScrollingEnabled(true);
		add(scroll);
	}
	
	public void log(String str) {
		console.append(str + "\n");
	}
}
