// Agent master in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

//+!run : catastrophe & intrude_0 <- callPolice(0, true);emExit(0, close).
		
+!run : catastrophe_0 & firealert_0 <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in first server room");
		callFireFighters(0, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(0, start);
		print("Veszkijaratok kinyitasa...");
		emExit(0, open);
		print("Veszkijaratok kinyitva.");
		emSpk(0, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		emDataSave(0, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(0);
		print("Szerverek leallitasa megtortent.").		

-catastrophe_0 <- print("Veszhelyzet elharitva.");
	callPolice(0, false);
	callFireFighters(0, false);
	emSpk(0," ");
	emExit(0, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(0);
	print("Szerverek elinditva.").		
		
		
	
+!run : catastrophe_1 & firealert_1 <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in second server room");
		callFireFighters(1, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(1, start);
		print("Veszkijaratok kinyitasa...");
		emExit(1, open);
		print("Veszkijaratok kinyitva.");
		emSpk(1, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		emDataSave(1, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(1);
		print("Szerverek leallitasa megtortent.").
			
-catastrophe_1 <- print("Veszhelyzet elharitva.");
	callPolice(1, false);
	callFireFighters(1, false);
	emSpk(1," ");
	emExit(1, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(1);
	print("Szerverek elinditva.").
			
/* Plans */

//elso szerverszoba tuz eseten
+firealert_0[source(A)] <- +catastrophe_0; !run.		
-firealert_0[source(A)] <- -catastrophe_0; !run.
	
//masodik szerverszoba tuz eseten
+firealert_1[source(A)] <- +catastrophe_1; !run.		
-firealert_1[source(A)] <- -catastrophe_1; !run.
	
//harmadik szerverszoba tuz eseten
+firealert_2[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in second server room");
		callFireFighters(2, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(2, start);
		print("Veszkijaratok kinyitasa...");
		emExit(2, open);
		print("Veszkijaratok kinyitva.");
		emSpk(2, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		emDataSave(2, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(2);
		print("Szerverek leallitasa megtortent.").
		
-firealert_2[source(A)]: true <- print("Veszhelyzet elharitva.");
	callPolice(2, false);
	callFireFighters(2, false);
	emSpk(2," ");
	emExit(2, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(2);
	print("Szerverek elinditva.").
	
//negyedik szerverszoba tuz eseten
+firealert_3[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in second server room");
		callFireFighters(3, true);
		print("Adatok mentese a biztonsagi szerverekre...");
		emDataSave(3, start);
		print("Veszkijaratok kinyitasa...");
		emExit(3, open);
		print("Veszkijaratok kinyitva.");
		emSpk(3, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		emDataSave(3, stop);
		print("Adatok mentese befejezodott.");
		print("Szerverek leallitasa...");
		stopServers(3);
		print("Szerverek leallitasa megtortent.").
		
-firealert_3[source(A)]: true <- print("Veszhelyzet elharitva.");
	callPolice(3, false);
	callFireFighters(3, false);
	emSpk(3," ");
	emExit(3, open);
	print("Szerverek inditasa...");
	.wait(2000);			
	startServers(3);
	print("Szerverek elinditva.").
		


+intrude_0[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in first server room"); +catastrophe; !run.
+intrude_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in second server room"); +catastrophe; !run.
+intrude_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in third server room"); +catastrophe; !run.
+intrude_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in fourth server room"); +catastrophe; !run.