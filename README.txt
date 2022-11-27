Uzasadnij swoje decyzje projektowe (zostaw na repozytorium "karteczkę" z krótkim
wyjaśnieniem, jaki był plan i dlaczego uważasz, że taki kod będzie i wydajny i łatwy w
utrzymaniu).


Trzymam posortowane po współrzędnych zarówno wertykalnie, jak i horyzontalnie obiekty.
W momencie dodania obiektu dodaje go i tu i tu, podobnie z jego usuwaniem.
Przy ruchu usuwam i dodaje jeszcze raz z nowa pozycja.

Dzieki temu w O(1) cały czas mam dostep do .first oraz .last i moge pobierac pozycje
a dodawanie nowego także nie jest liniowe i ma złożoność treeseta.