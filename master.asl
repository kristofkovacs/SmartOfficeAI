// Agent master in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

+!run : catastrophe & intrude <- callPolice(true);emExit(close).
							
+!run : catastrophe & firealert <- callFireFighters(true);
                                emDataSave(otherServers);
								emExit(open);								
								emServers(shutdown);
								emSpk("There is fire in the building! Please leave it following the exit instructions.").							
+!run : not catastrophe <- callPolice(false);
			callFireFighters(false);
			emServers(start);
			emExit(manual);
			emSpk(" ").		

/* Plans */

+firealert_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in first server room"); +catastrophe; !run.
+firealert_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in second server room"); +catastrophe; !run.
+firealert_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in third server room"); +catastrophe; !run.
+firealert_4[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in fourth server room"); +catastrophe; !run.

+intrude_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in first server room"); +catastrophe; !run.
+intrude_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in second server room"); +catastrophe; !run.
+intrude_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in third server room"); +catastrophe; !run.
+intrude_4[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in fourth server room"); +catastrophe; !run.