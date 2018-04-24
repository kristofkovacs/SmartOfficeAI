// Agent ta in project ierHF.mas2j

/* Initial beliefs and rules */
!start.
/* Initial goals */

/* Plans */
//szenzorok ovasása
+!start <-  !!run.

+!run : refresh(A,B,C,D,E,F) <- print("-----Szenzorok olvasása-----"); !checkT_1(A); !checkS_1(B);!checkT_2(C);!checkS_2(D);!checkT_3(E);!checkS_3(F); !!end.
+!run <- .print("Rendszer hiba: nincsenek szenzoradatok"); !!end.

+!end : (hightemperature_1 & hassmoke_1)|(hightemperature_2 & hassmoke_2)|(hightemperature_3 & hassmoke_3) <- .send(ba,tell,firealert); .wait(5000);  !!start.
+!end  <- .send(ba,untell,firealert); .wait(10000); !!start.

//elsõ szoba
+!checkT_1(N) : N > 45 <- +hightemperature_1; print("Magas a hõmérséklet az elsõ szobában").

+!checkT_1(N) : N <= 45 <-  -hightemperature_1; print("Alacsony a hõmérséklet az elsõ szobában").

+!checkS_1(N) : N == true <- +hassmoke_1; print("Magas a füstszint az elsõ szobában").

+!checkS_1(N) : N == false <- -hassmoke_1; print("Alacsony a füstszint az elsõ szobában").

//második szoba
+!checkT_2(N) : N > 45 <- +hightemperature_2; print("Magas a hõmérséklet a második szobában").

+!checkT_2(N) : N <= 45 <- -hightemperature_2; print("Alacsony a hõmérséklet a második szobában").

+!checkS_2(N) : N == true <- +hassmoke_2; print("Magas a füstszint a második szobában").

+!checkS_2(N) : N == false <- -hassmoke_2; print("Alacsony a füstszint a második szobában").

//harmadik szoba
+!checkT_3(N) : N > 45 <- +hightemperature_3; print("Magas a hõmérséklet a harmadik szobában").

+!checkT_3(N) : N <= 45 <- -hightemperature_3; print("Alacsony a hõmérséklet a harmadik szobában").

+!checkS_3(N) : N == true <- +hassmoke_3; print("Magas a füstszint a harmadik szobában").

+!checkS_3(N) : N == false <- -hassmoke_3; print("Alacsony a füstszint a harmadik szobában").
