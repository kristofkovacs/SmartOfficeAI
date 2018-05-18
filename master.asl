// Agent master in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

+!run : catastrophe & intrude_0 <- callPolice(0, true);emExit(0, close).
											
			
/* Plans */

//elso szerverszoba
+firealert_0[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in first server room");
		callFireFighters(0, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(0, start);
		print("Veszkijaratok kinyitasa...");
		emExit(0, open);
		print("Veszkijaratok kinyitva.");
		emSpk(0, "There is fire in the building! Please follow the exit instructions.");
		.wait(5000); //5 mp az adatmentesre eleg lesz
		emDataSave(0, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(0);
		print("Szerverek leallitasa megtortent.").
		
-firealert_0[source(A)]: true <- print("Veszhelyzet elharitva.");
	callPolice(0, false);
	callFireFighters(0, false);
	emSpk(0," ");
	emExit(0, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(0);
	print("Szerverek elinditva.").
	
//masodik szerverszoba
+firealert_1[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in second server room");
		callFireFighters(1, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(1, start);
		print("Veszkijaratok kinyitasa...");
		emExit(1, open);
		print("Veszkijaratok kinyitva.");
		emSpk(1, "There is fire in the building! Please follow the exit instructions.");
		.wait(5000); //5 mp az adatmentesre eleg lesz
		emDataSave(1, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(1);
		print("Szerverek leallitasa megtortent.").
		
-firealert_1[source(A)]: true <- print("Veszhelyzet elharitva.");
	callPolice(1, false);
	callFireFighters(1, false);
	emSpk(1," ");
	emExit(1, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(1);
	print("Szerverek elinditva.").
		

+firealert_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in third server room"); +catastrophe; !run.
+firealert_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in fourth server room"); +catastrophe; !run.

			

-firealert_2[source(A)]: true <- -catastrophe; !run.
-firealert_3[source(A)]: true <- -catastrophe; !run.

+intrude_0[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in first server room"); +catastrophe; !run.
+intrude_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in second server room"); +catastrophe; !run.
+intrude_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in third server room"); +catastrophe; !run.
+intrude_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in fourth server room"); +catastrophe; !run.