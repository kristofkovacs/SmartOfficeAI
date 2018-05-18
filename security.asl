// Agent security in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F,G,H,I,J,K,L) <- print("-----Reading states-----"); 
!checkAlarm_1(A);// !checkMovement_1(B); !checkAlarmPin_1(C);
//a tobbi szenzore majd ide jon
!!end.

+!run <- print("System error: can't read data from the current states"); !!end.

+alarmOn_1 <- checkMovement_1(B); wait(500).

+!end : (alarmOn_1 & movementDetected_1 & not correctPin_1) <- resetAlarmCounter_1(" "); startAlarmCounter_1(" "); .wait(30000); stopAlarmCounter_1(""); +alarmReachedZero_1; !!start.
+!end : (alarmOn_1 & movementDetected_1 & not correctPin_1 & alarmReachedZero_1) <- .send(master, tell, intrude_1); !!start.

//first serverRoom
+!checkAlarm_1(N) : N == true <- +alarmOn_1; activateAlarm_1(" "); print("The alarm is turned on in the first server room").

+!checkAlarm_1(N) : N == false <- -alarmOn_1; deactivateAlarm_1(" "); print("The alarm is turned off in the first server room").

+!checkMovement_1(N) : N == true <- +movementDetected_1; print("Movement detected in the first server room").

+!checkMovement_1(N) : N == false <- -movementDetected_1.

+!checkAlarmPin_1(N) : N == 1234 <- +correctPin_1; print("Valid pin code entered for alarm in the first server room").

+!checkAlarmPin_1(N) : N \== 1234 <- -correctPin_1; print("Invalid pin code entered for alarm in the first server room").

