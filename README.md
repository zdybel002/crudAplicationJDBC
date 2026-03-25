System Zarządzania Biblioteką (Library Manager)
Prosta aplikacja webowa typu CRUD stworzona w ramach nauki frameworka Spring MVC. 
Projekt pozwala na zarządzanie bazą czytelników oraz katalogiem książek, 
a także umożliwia przypisywanie konkretnych pozycji do osób

Funkcjonalności

Zarządzanie Książkami:
Przeglądanie pełnej listy książek.
Dodawanie nowych pozycji (Tytuł, Autor, Rok wydania).
Edycja danych istniejących książek.
Usuwanie książek z systemu.
System wypożyczeń: Możliwość przypisania wolnej książki do wybranego czytelnika lub jej zwolnienia (release).


<img width="2480" height="1772" alt="Untitled-3" src="https://github.com/user-attachments/assets/f97e1e98-4435-4d4f-93c7-12c3890d2944" />


Zarządzanie Czytelnikami:
Lista wszystkich zarejestrowanych osób.
Dodawanie nowych czytelników (Imię i nazwisko, Rok urodzenia).
Podgląd profilu osoby wraz z listą aktualnie wypożyczonych przez nią książek.
Edycja i usuwanie danych osobowych.

Walidacja i UI:
Pełna walidacja pól (np. wymagane imię, poprawny rok).
Wyraźne komunikaty błędów w kolorze czerwonym.
Nowoczesny, minimalistyczny interfejs w stonowanej, szarej kolorystyce (Slate Grey Style).

Technologia
Java 17+

Spring Framework (Spring MVC)
Thymeleaf (Silnik szablonów HTML)
Hibernate Validator (Walidacja danych)
CSS3 (Customowe zmienne :root, Responsive Design)
Maven (Zarządzanie zależnościami)
