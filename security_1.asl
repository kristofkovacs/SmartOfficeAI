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
		resetAlarmCounter(1); 
		startAlarmCounter(1); 
		.wait(10000); 
		stopAlarmCounter(1); 
		+alarmReachedZero;
		.wait(20000);		
		-timerStarted;		
		!!start.
		
+alarmReachedZero: (not correctPin & alarmOn) <- .send(master, tell, intrude_1).
+correctPin <- stopAlarmCounter(1); 
	-alarmOn; 	
	.send(master, untell, intrude_1); 
	-correctPin.

+alarmOn <- activateAlarm(1); print("The alarm is turned on in the second server room").
-alarmOn <- stopAlarmCounter(1);
	deactivateAlarm(1);
	.wait(500);	
	resetAlarmCounter(1);
	print("The alarm is turned off in the second server room");
	.send(master, untell, intrude_1);
	-alarmReachedZero.
	
+correctPin <- print("Valid pin code entered for alarm in the second server room").
+movementDetected <- print("Movement detected in the second server room").

//second serverRoom
+!checkAlarm(N) : N == true & not correctPin <- +alarmOn.

+!checkAlarm(N) : N == false <- -alarmOn.

+!checkMovement(N) : N == true <- +movementDetected.

+!checkMovement(N) : N == false <- -movementDetected.

+!checkAlarmPin(N) : N == 1234 <- +correctPin.

+!checkAlarmPin(N) : N \== 1234 <- -correctPin; print("Invalid pin code entered for alarm in the second server room").

