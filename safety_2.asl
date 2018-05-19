// Agent safety in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F,G,H) <- print("-----Reading states-----"); 
!checkTemperature(E); !checkSmoke(F);
!!end.

+!run <- print("System error: can't read data from the current states"); !!end.


+!end : (hightemperature & hassmoke) <- .send(master,tell,firealert_2); .wait(5000); !!start.

+!end  <- .send(master,untell,firealert_2); .wait(10000); !!start.

//first serverRoom
+!checkTemperature(N) : N > 45 <- +hightemperature; print("High temperature in the first server room").
+!checkTemperature(N) : N <= 45 <-  -hightemperature; print("Normal temperature in the first server room").

+!checkSmoke(N) : N == true <- +hassmoke; print("Smoke detected in the first server room").
+!checkSmoke(N) : N == false <- -hassmoke; print("Clear air in the first server room").