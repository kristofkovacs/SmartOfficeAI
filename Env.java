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

import GUI;

public class Env extends Environment {
	
    private GUI gui;

	
	public void log(String message){
		gui.log(message);
	}
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		
		 gui = new GUI();
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



