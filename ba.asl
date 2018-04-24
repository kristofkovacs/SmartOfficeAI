// Agent ba in project ierHF.mas2j



/* Initial beliefs and rules */



/* Initial goals */

+!run : catastrophe & accident <- emCall(ambulance).
+!run : catastrophe & robbery <- emCall(police);
							emExit(close);
							emeGate(close).
+!run : catastrophe & firealert <- emCall(firefighters);
								emExit(open);
								emGate(open);
								emEle(false);
								emSpk("Mindeki fegyelmezetten hagyja el az �p�letet!").							
+!run : not catasrophe <- emCall(standby);
						emExit(manual);
						emGate(manual);
						emEle(true);
						emSpk(" ").		





/* Plans */



+firealert[source(A)]: true <- print("-----Kapott �zenet ki�rt�kel�se-----"); print("T�z elleni protokol ind�t�sa"); +catastrophe; !run.

-firealert[source(A)]: true <- print("-----Kapott �zenet ki�rt�kel�se-----"); print("Minden rendben"); -catastrophe; !run.

+robbery[source(A)]: true <- print("-----Kapott �zenet ki�rt�kel�se-----"); print("Bet�r�s elleni protokol ind�t�sa"); +catastrophe; !run.

+accident[source(A)]: true <- print("-----Kapott �zenet ki�rt�kel�se-----"); print("Baleset elleni protokol ind�t�sa"); +catastrophe; !run.
