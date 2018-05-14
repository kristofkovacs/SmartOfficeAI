// Agent security in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C) <- print("-----Reading states-----"); !checkAlarm_1(A); !checkMovement_1(B); !checkAlarmPin_1(C); !!end.
+!run <- .print("System error: can't read data from the current states"); !!end.

+!end : (alarmOn & movementDetected & !correctPin) .wait(30000);  !!start.
+!end  <- .send(room,untell,intrude); .wait(10000); !!start.

//alarm status detection
+!checkAlarm(N) : N == true <- +alarmOn; print("The alarm is turned on in the server room").

+!checkAlarm(N) : N == false <- -alarmOn; print("The alarm is turned off in the server room").

+!checkMovement(N) : N == true <- +movementDetected; print("Movement detected in the server room")

+!checkAlarmPin(N) : N == 1234 <- +correctPin; print("Valid pin code entered for alarm in the server room").

+!checkAlarmPin(N) : N != 1234 <- -correctPin; print("Invalid pin code entered for alarm in the server room").
//alarmTimerCountDown