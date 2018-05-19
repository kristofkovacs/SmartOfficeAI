// Agent security in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C) <- 
	print("-----Reading states-----"); 
	!checkAlarm(A);
	!checkMovement(B);
	!checkAlarmAndMovement(C);
	!!end.

+!run <- print("System error: can't read data from the current states"); !!end.

+!checkAlarmAndMovement(X): (alarmOn & movementDetected) <- !checkAlarmPin(X); .wait(1000); !!start.
+!checkAlarmAndMovement(X) <-.wait(5000); !!start.

+!end : (alarmOn & movementDetected & not correctPin) <- +timerStarted.

+timerStarted <-
		resetAlarmCounter(3); 
		startAlarmCounter(3); 
		.wait(10000); 
		stopAlarmCounter(3); 
		+alarmReachedZero;
		.wait(20000);		
		-timerStarted;		
		!!start.
		
+alarmReachedZero: (not correctPin & alarmOn) <- .send(master, tell, intrude_3).
+correctPin <- stopAlarmCounter(3); 
	-alarmOn; 	
	.send(master, untell, intrude_3); 
	-correctPin.

+alarmOn <- activateAlarm(3); print("The alarm is turned on in the fourth server room").
-alarmOn <- stopAlarmCounter(3);
	deactivateAlarm(3);
	.wait(500);	
	resetAlarmCounter(3);
	print("The alarm is turned off in the fourth server room");
	.send(master, untell, intrude_3);
	-alarmReachedZero.
	
+correctPin <- print("Valid pin code entered for alarm in the fourth server room").
+movementDetected <- print("Movement detected in the fourth server room").

//fourth serverRoom
+!checkAlarm(N) : N == true & not correctPin <- +alarmOn.

+!checkAlarm(N) : N == false <- -alarmOn.

+!checkMovement(N) : N == true <- +movementDetected.

+!checkMovement(N) : N == false <- -movementDetected.

+!checkAlarmPin(N) : N == 1234 <- +correctPin.

+!checkAlarmPin(N) : N \== 1234 <- -correctPin; print("Invalid pin code entered for alarm in the fourth server room").

