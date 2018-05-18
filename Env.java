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

public class Env extends Environment {
	
    private GUI gui;
	
	private AlarmTimerThread alarmTimer1;
	private AlarmTimerThread alarmTimer2;
	private AlarmTimerThread alarmTimer3;
	private AlarmTimerThread alarmTimer4;
	

	
	public void log(String message){
		gui.log(message);
	}
	
	public void updateSensorStates(List<RoomControl> roomControls){
		RoomControl room1 = roomControls.get(0);
		RoomControl room2 = roomControls.get(1);
		RoomControl room3 = roomControls.get(2);
		RoomControl room4 = roomControls.get(3);
		
		try{
			clearPercepts("safety");
				addPercept("safety", 
					ASSyntax.createLiteral("refresh",
						ASSyntax.parseTerm(String.valueOf(room1.getTemperatureSensorValue())),
						ASSyntax.parseTerm(String.valueOf(room1.isThereSmoke())),
						ASSyntax.parseTerm(String.valueOf(room2.getTemperatureSensorValue())),
						ASSyntax.parseTerm(String.valueOf(room2.isThereSmoke())),
						ASSyntax.parseTerm(String.valueOf(room3.getTemperatureSensorValue())),
						ASSyntax.parseTerm(String.valueOf(room3.isThereSmoke())),
						ASSyntax.parseTerm(String.valueOf(room4.getTemperatureSensorValue())),
						ASSyntax.parseTerm(String.valueOf(room4.isThereSmoke()))
						));
						
			clearPercepts("security");
				addPercept("security", 
					ASSyntax.createLiteral("refresh",
						ASSyntax.parseTerm(String.valueOf(room1.isAlarmed())),
						ASSyntax.parseTerm(String.valueOf(room1.isThereMotion())),
						ASSyntax.parseTerm(room1.getAlarmTextInputValue()),
						ASSyntax.parseTerm(String.valueOf(room2.isAlarmed())),
						ASSyntax.parseTerm(String.valueOf(room2.isThereMotion())),
						ASSyntax.parseTerm(room2.getAlarmTextInputValue()),
						ASSyntax.parseTerm(String.valueOf(room3.isAlarmed())),
						ASSyntax.parseTerm(String.valueOf(room3.isThereMotion())),
						ASSyntax.parseTerm(room3.getAlarmTextInputValue()),
						ASSyntax.parseTerm(String.valueOf(room4.isAlarmed())),
						ASSyntax.parseTerm(String.valueOf(room4.isThereMotion())),
						ASSyntax.parseTerm(room4.getAlarmTextInputValue())					
						));				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e2){
			e2.printStackTrace();
		}
	}

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		
		 gui = new GUI(this);
		 
		 gui.actionPerformed(null);//init sensor values
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
		
		List<AgentInfo> outputs = gui.getAgentOutputs();
		
		switch (action.getFunctor()) {
			case  "print": 
				gui.log(agName, action.getTerm(0).toString());
				break;
			case  "callPolice": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					output.callPolice(Boolean.parseBoolean(action.getTerm(0).toString()));
				}
				break;
			case  "callFireFighters": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					output.callFireFighers(Boolean.parseBoolean(action.getTerm(0).toString()));
				}
				break;
			//case  "emEle": gui.emergencyElevator(Boolean.parseBoolean(action.getTerm(0).toString()));
			//				break;
			case  "emExit": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					if("close".equals(action.getTerm(0).toString()))
						output.closeDoors();
					else
						output.openDoors();
				}
				break;
			case  "emSpk": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					output.setAlarm(action.getTerm(0).toString());
				}
				break;	
			case  "emDataSave": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					output.sendBackupData();
				}
				break;		
			case  "emServers": 
				for(AgentInfo output : outputs){//egyenlore mindenhova kiirjuk
					output.stopBackup();
				}
				break;		
			case "startAlarmCounter_1":
				if(alarmTimer1 != null)
					alarmTimer1.stopCounter();
				alarmTimer1 = new AlarmTimerThread(outputs.get(0));
				
				(new Thread(alarmTimer1)).start();				
				break;		
			case "stopAlarmCounter_1":
				if(alarmTimer1 == null)
					break;
				
				alarmTimer1.stopCounter();				
				break;
			default: gui.log("executing: "+action+", but not implemented!");
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



