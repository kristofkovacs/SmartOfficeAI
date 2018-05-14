// Agent safety in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//state reading
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F,G,H) <- print("-----Reading states-----"); !checkT_1(A); !checkS_1(B);!checkT_2(C);!checkS_2(D);!checkT_3(E);!checkS_3(F); !checkT_3(G);!checkS_3(H); !!end.
+!run <- .print("System error: can't read data from the current states"); !!end.

+!end : (hightemperature_1 & hassmoke_1)|(hightemperature_2 & hassmoke_2)|(hightemperature_3 & hassmoke_3)|(hightemperature_4 & hassmoke_4) <- .send(ba,tell,firealert); .wait(5000);  !!start.
+!end  <- .send(ba,untell,firealert); .wait(10000); !!start.

//first serverRoom
+!checkT_1(N) : N > 45 <- +hightemperature_1; print("High temperature in the first server room").

+!checkT_1(N) : N <= 45 <-  -hightemperature_1; print("Normal temperature in the first server room").

+!checkS_1(N) : N == true <- +hassmoke_1; print("Smoke detected in the first server room").

+!checkS_1(N) : N == false <- -hassmoke_1; print("Clear air in the first server room").

//second serverRoom
+!checkT_2(N) : N > 45 <- +hightemperature_2; print("High temperature in the second server room").

+!checkT_2(N) : N <= 45 <-  -hightemperature_2; print("Normal temperature in the second server room").

+!checkS_2(N) : N == true <- +hassmoke_2; print("Smoke detected in the second server room").

+!checkS_2(N) : N == false <- -hassmoke_2; print("Clear air in the second server room").

//third serverRoom
+!checkT_3(N) : N > 45 <- +hightemperature_3; print("High temperature in the third server room").

+!checkT_3(N) : N <= 45 <-  -hightemperature_3; print("Normal temperature in the third server room").

+!checkS_3(N) : N == true <- +hassmoke_3; print("Smoke detected in the third server room").

+!checkS_3(N) : N == false <- -hassmoke_3; print("Clear air in the third server room").

//fourth serverRoom
+!checkT_4(N) : N > 45 <- +hightemperature_4; print("High temperature in the fourth server room").

+!checkT_4(N) : N <= 45 <-  -hightemperature_4; print("Normal temperature in the fourth server room").

+!checkS_4(N) : N == true <- +hassmoke_4; print("Smoke detected in the fourth server room").

+!checkS_4(N) : N == false <- -hassmoke_4; print("Clear air in the fourth server room").