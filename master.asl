// Agent master in project ierHF.mas2j



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
								emSpk("Mindeki fegyelmezetten hagyja el az épületet!").							
+!run : not catasrophe <- emCall(standby);
						emExit(manual);
						emGate(manual);
						emEle(true);
						emSpk(" ").		





/* Plans */



+firealert[source(A)]: true <- print("-----Kapott üzenet kiértékelése-----"); print("Tüz elleni protokol indítása"); +catastrophe; !run.

-firealert[source(A)]: true <- print("-----Kapott üzenet kiértékelése-----"); print("Minden rendben"); -catastrophe; !run.

+robbery[source(A)]: true <- print("-----Kapott üzenet kiértékelése-----"); print("Betörés elleni protokol indítása"); +catastrophe; !run.

+accident[source(A)]: true <- print("-----Kapott üzenet kiértékelése-----"); print("Baleset elleni protokol indítása"); +catastrophe; !run.