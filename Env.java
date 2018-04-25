// Environment code for project ierHF.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;

import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Term;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.text.DefaultCaret;

public class Env extends Environment {
	
    private Gui gui;

    private Logger logger = Logger.getLogger("ierHF.mas2j."+Env.class.getName());

	public void refreshSensors(Object t1, Object s1,Object t2, Object s2,Object t3, Object s3) {
		try{
		 clearPercepts("ta");
		 addPercept("ta",ASSyntax.createLiteral("refresh",ASSyntax.parseTerm(t1.toString()),ASSyntax.parseTerm(s1.toString()),ASSyntax.parseTerm(t2.toString()),ASSyntax.parseTerm(s2.toString()),ASSyntax.parseTerm(t3.toString()),ASSyntax.parseTerm(s3.toString())));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void print(String message){
		gui.writeConsole(message);
	}
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		
		 gui = new Gui();
        gui.setEnvironment(this);
		
		refreshSensors(25,false,25,false,25,false);
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        switch (action.getFunctor()) {
			case  "print": gui.writeConsole("["+agName+"] " +  new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + " : "+action.getTerm(0).toString());
							break;
			case  "emCall": gui.emergencyCall(action.getTerm(0).toString());
							break;
			case  "emEle": gui.emergencyElevator(Boolean.parseBoolean(action.getTerm(0).toString()));
							break;
			case  "emExit": gui.emergencyExits(action.getTerm(0).toString());
							break;
			case  "emGate": gui.emergencyGates(action.getTerm(0).toString());
							break;		
			case  "emSpk": gui.emergencySpeakers(action.getTerm(0).toString());
							break;
			default: logger.info("executing: "+action+", but not implemented!");
					 break;
		}
	
        if (true) { // you may improve this condition
             informAgsEnvironmentChanged();
        }
        return true; // the action was executed with success 
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}



