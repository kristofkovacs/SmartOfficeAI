// Agent ta in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//szenzorok ovas�sa
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F) <- print("-----Szenzorok olvas�sa-----"); !checkT_1(A); !checkS_1(B);!checkT_2(C);!checkS_2(D);!checkT_3(E);!checkS_3(F); !!end.
+!run <- .print("Rendszer hiba: nincsenek szenzoradatok"); !!end.

+!end : (hightemperature_1 & hassmoke_1)|(hightemperature_2 & hassmoke_2)|(hightemperature_3 & hassmoke_3) <- .send(ba,tell,firealert); .wait(5000);  !!start.
+!end  <- .send(ba,untell,firealert); .wait(10000); !!start.

//els� szoba
+!checkT_1(N) : N > 45 <- +hightemperature_1; print("Magas a h�m�rs�klet az els� szob�ban").

+!checkT_1(N) : N <= 45 <-  -hightemperature_1; print("Alacsony a h�m�rs�klet az els� szob�ban").

+!checkS_1(N) : N == true <- +hassmoke_1; print("Magas a f�stszint az els� szob�ban").

+!checkS_1(N) : N == false <- -hassmoke_1; print("Alacsony a f�stszint az els� szob�ban").

//m�sodik szoba
+!checkT_2(N) : N > 45 <- +hightemperature_2; print("Magas a h�m�rs�klet a m�sodik szob�ban").

+!checkT_2(N) : N <= 45 <- -hightemperature_2; print("Alacsony a h�m�rs�klet a m�sodik szob�ban").

+!checkS_2(N) : N == true <- +hassmoke_2; print("Magas a f�stszint a m�sodik szob�ban").

+!checkS_2(N) : N == false <- -hassmoke_2; print("Alacsony a f�stszint a m�sodik szob�ban").

//harmadik szoba
+!checkT_3(N) : N > 45 <- +hightemperature_3; print("Magas a h�m�rs�klet a harmadik szob�ban").

+!checkT_3(N) : N <= 45 <- -hightemperature_3; print("Alacsony a h�m�rs�klet a harmadik szob�ban").

+!checkS_3(N) : N == true <- +hassmoke_3; print("Magas a f�stszint a harmadik szob�ban").

+!checkS_3(N) : N == false <- -hassmoke_3; print("Alacsony a f�stszint a harmadik szob�ban").
