// Agent master in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

+!run : intrude <- emCall(police);
							emExit(close);
							emeGate(close).
+!run : firealert <- emCall(firefighters);
                                emDataSave(otherServers);
								emExit(open);
								emGate(open);
								emServers(shutdown);
								emSpk("There is fire in the building! Please leave it following the exit instructions.").							
+!run : <- emCall(standby);
			emServers(start);
			emExit(manual);
			emGate(manual);
			emSpk(" ").		

/* Plans */

+firealert_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in first server room"); !run.
+firealert_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in second server room"); !run.
+firealert_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in third server room"); !run.
+firealert_4[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke in fourth server room"); !run.

+intrude_1[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in first server room"); !run.
+intrude_2[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in second server room"); !run.
+intrude_3[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in third server room"); !run.
+intrude_4[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder in fourth server room"); !run.