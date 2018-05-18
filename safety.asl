// Agent safety in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F,G,H) <- print("-----Reading states-----"); 
!checkTemperature_0(A); !checkSmoke_0(B);
!checkTemperature_1(C); !checkSmoke_1(D);
!checkTemperature_2(E); !checkSmoke_2(F); 
!checkTemperature_3(G); !checkSmoke_3(H); 
!!end.

+!run <- print("System error: can't read data from the current states"); !!end.

+!end : (hightemperature_0 & hassmoke_0) <- .send(master,tell,firealert_0); .wait(5000);  !!start.
+!end : (hightemperature_1 & hassmoke_1) <- .send(master,tell,firealert_1); .wait(5000);  !!start.
+!end : (hightemperature_2 & hassmoke_2) <- .send(master,tell,firealert_2); .wait(5000);  !!start.
+!end : (hightemperature_3 & hassmoke_3) <- .send(master,tell,firealert_3); .wait(5000);  !!start.

+!end  <- .send(master,untell,firealert_0); .wait(10000); !!start.
+!end  <- .send(master,untell,firealert_1); .wait(10000); !!start.
+!end  <- .send(master,untell,firealert_2); .wait(10000); !!start.
+!end  <- .send(master,untell,firealert_3); .wait(10000); !!start.

//first serverRoom
+!checkTemperature_0(N) : N > 45 <- +hightemperature_0; print("High temperature in the first server room").
+!checkTemperature_0(N) : N <= 45 <-  -hightemperature_0; print("Normal temperature in the first server room").

+!checkSmoke_0(N) : N == true <- +hassmoke_0; print("Smoke detected in the first server room").
+!checkSmoke_0(N) : N == false <- -hassmoke_0; print("Clear air in the first server room").

//second serverRoom
+!checkTemperature_1(N) : N > 45 <- +hightemperature_1; print("High temperature in the second server room").
+!checkTemperature_1(N) : N <= 45 <-  -hightemperature_1; print("Normal temperature in the second server room").

+!checkSmoke_1(N) : N == true <- +hassmoke_1; print("Smoke detected in the second server room").
+!checkSmoke_1(N) : N == false <- -hassmoke_1; print("Clear air in the second server room").

//third serverRoom
+!checkTemperature_2(N) : N > 45 <- +hightemperature_2; print("High temperature in the third server room").
+!checkTemperature_2(N) : N <= 45 <-  -hightemperature_2; print("Normal temperature in the third server room").

+!checkSmoke_2(N) : N == true <- +hassmoke_2; print("Smoke detected in the third server room").
+!checkSmoke_2(N) : N == false <- -hassmoke_2; print("Clear air in the third server room").

//fourth serverRoom
+!checkTemperature_3(N) : N > 45 <- +hightemperature_3; print("High temperature in the fourth server room").
+!checkTemperature_3(N) : N <= 45 <-  -hightemperature_3; print("Normal temperature in the fourth server room").

+!checkSmoke_3(N) : N == true <- +hassmoke_3; print("Smoke detected in the fourth server room").
+!checkSmoke_3(N) : N == false <- -hassmoke_3; print("Clear air in the fourth server room").