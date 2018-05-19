// Agent master in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

			
/* Plans */

//elso szerverszoba tuz eseten
+firealert_0[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in first server room");
		callFireFighters(0, "In progress...");		
		print("Saving data to the cloud...");
		emDataSave(0, start);
		print("Opening emergency exits...");
		emExit(0, open);
		print("Emergency exits are opened.");
		emSpk(0, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		callFireFighters(0, "Firefighters on their way!");	
		emDataSave(0, stop);
		print("Data saving has been finished.");
		print("Shutting down the servers...");
		stopServers(0);
		.wait(1000);
		print("Successful server shutdown.").
		
-firealert_0[source(A)]: true <- print("Emergency protocols successful.");
	callFireFighters(0, "");
	emSpk(0," ");
	emExit(0, open);
	print("Restarting the servers...");
	.wait(2000);			
	startServers(0);
	print("Servers are up and running.").
	
//masodik szerverszoba tuz eseten
+firealert_1[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in second server room");
		callFireFighters(1, "In progress...");		
		print("Saving data to the cloud...");
		emDataSave(1, start);
		print("Opening emergency exits...");
		emExit(1, open);
		print("Emergency exits are opened.");
		emSpk(1, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		callFireFighters(1, "Firefighters on their way!");	
		emDataSave(1, stop);
		print("Data saving has been finished.");
		print("Shutting down the servers...");
		stopServers(1);
		.wait(1000);
		print("Successful server shutdown.").
		
-firealert_1[source(A)]: true <- print("Emergency protocols successful.");
	callFireFighters(1, "");
	emSpk(1," ");
	emExit(1, open);
	print("Restarting the servers...");
	.wait(2000);			
	startServers(1);
	print("Servers are up and running.").
	
//harmadik szerverszoba tuz eseten
+firealert_2[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in third server room");
		callFireFighters(2, "In progress...");		
		print("Saving data to the cloud...");
		emDataSave(2, start);
		print("Opening emergency exits...");
		emExit(2, open);
		print("Emergency exits are opened.");
		emSpk(2, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		callFireFighters(2, "Firefighters on their way!");	
		emDataSave(2, stop);
		print("Data saving has been finished.");
		print("Shutting down the servers...");
		stopServers(2);
		.wait(1000);
		print("Successful server shutdown.").
		
-firealert_2[source(A)]: true <- print("Emergency protocols successful.");
	callFireFighters(2, "");
	emSpk(2," ");
	emExit(2, open);
	print("Restarting the servers...");
	.wait(2000);			
	startServers(2);
	print("Servers are up and running.").
	
//negyedik szerverszoba tuz eseten
+firealert_3[source(A)]: true <- print("-----Reading states-----"); 
		print("Starting protocol against fire and smoke in fourth server room");
		callFireFighters(3, "In progress...");		
		print("Saving data to the cloud...");
		emDataSave(3, start);
		print("Opening emergency exits...");
		emExit(3, open);
		print("Emergency exits are opened.");
		emSpk(3, "There is fire in the building! Please follow the exit instructions.");
		.wait(2500); //2,5 mp az adatmentesre eleg lesz
		callFireFighters(3, "Firefighters on their way!");	
		emDataSave(3, stop);
		print("Data saving has been finished.");
		print("Shutting down the servers...");
		stopServers(3);
		.wait(1000);
		print("Successful server shutdown.").
		
-firealert_3[source(A)]: true <- print("Emergency protocols successful.");
	callFireFighters(3, "");
	emSpk(3," ");
	emExit(3, open);
	print("Restarting the servers...");
	.wait(2000);			
	startServers(3);
	print("Servers are up and running.").

//elso szobaban betores
+intrude_0[source(A)]: true <- print("-----Reading states-----"); 
	print("Starting protocol against intruder in first server room"); 
	callPolice(0, "In progress...");
	emExit(0, close);
	emSpk(0, "!!!Intrude in first server room!!!")
	.wait(1000);
	callPolice(0, "Police is on its way!").
	
-intrude_0[source(A)]: true <- print("-----Reading states-----"); 
	callPolice(0, "");
	emExit(0, open);
	emSpk(0, " ").
	
//masodik szobaban betores
+intrude_1[source(A)]: true <- print("-----Reading states-----"); 
	print("Starting protocol against intruder in second server room"); 
	callPolice(1, "In progress...");
	emExit(1, close);
	emSpk(1, "!!!Intrude in second server room!!!")
	.wait(1000);
	callPolice(1, "Police is on its way!").
	
-intrude_1[source(A)]: true <- print("-----Reading states-----"); 
	callPolice(1, "");
	emExit(1, open);
	emSpk(1, " ").
	
//harmadik szobaban betores
+intrude_2[source(A)]: true <- print("-----Reading states-----"); 
	print("Starting protocol against intruder in third server room"); 
	callPolice(2, "In progress...");
	emExit(2, close);
	emSpk(2, "!!!Intrude in third server room!!!")
	.wait(1000);
	callPolice(2, "Police is on its way!").
	
-intrude_2[source(A)]: true <- print("-----Reading states-----"); 
	callPolice(2, "");
	emExit(2, open);
	emSpk(2, " ").
	
//negyedik szobaban betores
+intrude_3[source(A)]: true <- print("-----Reading states-----"); 
	print("Starting protocol against intruder in fourth server room"); 
	callPolice(3, "In progress...");
	emExit(3, close);
	emSpk(3, "!!!Intrude in fourth server room!!!")
	.wait(1000);
	callPolice(3, "Police is on its way!").
	
-intrude_3[source(A)]: true <- print("-----Reading states-----"); 
	callPolice(3, "");
	emExit(3, open);
	emSpk(3, " ").
