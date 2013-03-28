algorithms-sem2
===============

Harris Ross Algorithms from beginning



Sortowanie Shella bierze wg zadanego ciągu : np. n = 1,3,5 .. n-te wyrazy ciagu i tworzy podciągi które są następnie sortowane jedną z metod sortowania podstawowego ( np. przez wstawianie )

czyli np najpierw co 5 element i sortuje podciągi A1,A6,A11 | A2,A7,A12 ..

Następnie co 3 A1,A4,A7 | A2,A5,A8 ..

I na końcu gdy tablica już jest prawie cała posortowana bierze co 1 czyli sortuje całą tablice 

.. 

Ciekawszy podProjekt .. lesson3.CallCenter

Wykorzystuje wzorzec projektowy : fabryka.
Przykład wykorzystania kolejki blokującej w postaci prostego CallCenter.

Fabryką jest klasa CallGenerator która generuje egzemplarze klasy Call.
Zgłoszenia są wstawianie do kolejki blokującej która gdy jest pełna nie wyrzuca wyjątku tylko czeka aż znowu zwolni się miejsce.

Klasa Consultant realizuje zlecenia(Call). Jest 3 konsultantów którzy przy użyciu architektury wielowątkowej realizują zlecenia.
CallCenter generuje zlecenia które trwają losowa ilość milisekund .. generuje ich określoną ilość tak żeby applikacja nie trwała bez końca.

Nie wpadłem sam na pomysł jak zrealizować CallCenter w postaci kolejki blokującej i wieluwątków, ale znając pomysł sam zaimplementowałem kod. 


