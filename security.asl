// Agent security in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F,G,H,I,J,K,L) <- print("-----Reading states-----"); !checkAlarm_1(A); !checkMovement_1(B); !checkAlarmPin_1(C); !checkAlarm_2(D); !checkMovement_2(E); !checkAlarmPin_2(F); !checkAlarm_3(G); !checkMovement_3(H); !checkAlarmPin_3(I); !checkAlarm_4(J); !checkMovement_4(K); !checkAlarmPin_4(L); !!end.
+!run <- .print("System error: can't read data from the current states"); !!end.

+!end : (alarmOn_1 && movementDetected_1)

+!end : (hightemperature_1 & hassmoke_1)|(hightemperature_2 & hassmoke_2)|(hightemperature_3 & hassmoke_3)|(hightemperature_4 & hassmoke_4) <- .send(ba,tell,firealert); .wait(5000);  !!start.
+!end  <- .send(ba,untell,firealert); .wait(10000); !!start.

//first serverRoom
+!checkAlarm_1(N) : N == true <- +alarmOn_1; print("The alarm is turned on in the first server room").

+!checkAlarm_1(N) : N == false <- -alarmOn_1; print("The alarm is turned off in the first server room").

+!checkMovement_1(N) : N == true <- +movementDetected_1; print("Movement detected in the first server room")

+!checkAlarmPin_1(N) : N == 1234 <- +correctPin_1; print("Valid pin code entered for alarm in the first server room").

+!checkAlarmPin_1(N) : N != 1234 <- -correctPin_1; print("Invalid pin code entered for alarm in the first server room").
//alarmTimerCountDown

//second serverRoom
+!checkAlarm_2(N) : N == true <- +alarmOn_2; print("The alarm is turned on in the second server room").

+!checkAlarm_2(N) : N == false <- -alarmOn_2; print("The alarm is turned off in the second server room").

+!checkMovement_2(N) : N == true <- +movementDetected_2; print("Movement detected in the second server room")

+!checkAlarmPin_2(N) : N == 1234 <- +correctPin_2; print("Valid pin code entered for alarm in the second server room").

+!checkAlarmPin_2(N) : N != 1234 <- -correctPin_2; print("Invalid pin code entered for alarm in the second server room").


//third serverRoom
+!checkAlarm_3(N) : N == true <- +alarmOn_3; print("The alarm is turned on in the third server room").

+!checkAlarm_3(N) : N == false <- -alarmOn_3; print("The alarm is turned off in the third server room").

+!checkMovement_3(N) : N == true <- +movementDetected_3; print("Movement detected in the third server room")

+!checkAlarmPin_3(N) : N == 1234 <- +correctPin_3; print("Valid pin code entered for alarm in the third server room").

+!checkAlarmPin_3(N) : N != 1234 <- -correctPin_3; print("Invalid pin code entered for alarm in the third server room").


//fourth serverRoom
+!checkAlarm_4(N) : N == true <- +alarmOn_4; print("The alarm is turned on in the fourth server room").

+!checkAlarm_4(N) : N == false <- -alarmOn_4; print("The alarm is turned off in the fourth server room").

+!checkMovement_4(N) : N == true <- +movementDetected_4; print("Movement detected in the fourth server room")

+!checkAlarmPin_4(N) : N == 1234 <- +correctPin_4; print("Valid pin code entered for alarm in the fourth server room").

+!checkAlarmPin_4(N) : N != 1234 <- -correctPin_4; print("Invalid pin code entered for alarm in the fourth server room").
