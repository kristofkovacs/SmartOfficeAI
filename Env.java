// Environment code for project ierHF.mas2j

import jason.asSyntax.*;
import jason.environment.*;

import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Term;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import RoomControl;

import GUI;

public class Env extends Environment {
	
    private GUI gui;

	
	public void log(String message){
		gui.log(message);
	}
	
	public void updateSensorStates(List<RoomControl> roomControls){
		for(RoomControl room: roomControls){
			try{
				//clearPercepts("ta");
				//addPercept("ta",ASSyntax.createLiteral("refresh",ASSyntax.parseTerm(t1.toString()),ASSyntax.parseTerm(s1.toString()),ASSyntax.parseTerm(t2.toString()),ASSyntax.parseTerm(s2.toString()),ASSyntax.parseTerm(t3.toString()),ASSyntax.parseTerm(s3.toString())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		
		 gui = new GUI(this);
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        switch (action.getFunctor()) {
			case  
			default: 
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



