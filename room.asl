// Agent room in project ierHF.mas2j


/* Initial beliefs and rules */


/* Initial goals */

+!run : catastrophe & intrude <- emCall(police);
							emExit(close);
							emeGate(close).
+!run : catastrophe & firealert <- emCall(firefighters);
                                emDataSave(otherServers);
								emExit(open);
								emGate(open);
								emEle(false);
								emSpk("There is fire in the building! Please leave it following the exit instructions.").							
+!run : not catasrophe <- emCall(standby);
						emExit(manual);
						emGate(manual);
						emEle(true);
						emSpk(" ").		


/* Plans */



+firealert[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against fire and smoke..."); +catastrophe; !run.

-firealert[source(A)]: true <- print("-----Reading states-----"); print("Everything seems normal"); -catastrophe; !run.

+intrude[source(A)]: true <- print("-----Reading states-----"); print("Starting protocol against intruder..."); +catastrophe; !run.