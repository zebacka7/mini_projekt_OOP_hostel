# System Zarządzania Hostelem (Hostel Management System)

Prosta aplikacja konsolowa napisana w języku Java, służąca do zarządzania rezerwacjami w hostelu. Projekt został stworzony w ramach zaliczenia przedmiotu "Programowanie Obiektowe".

##  Opis projektu

Celem projektu jest symulacja działania systemu rezerwacyjnego. Aplikacja pozwala na zarządzanie różnymi typami pokoi (pokoje jednoosobowe, pokoje wieloosobowe typu Dorm), obsługę gości oraz tworzenie rezerwacji.

Głównym naciskiem w projekcie jest praktyczne zastosowanie paradygmatów programowania obiektowego (OOP).

##  Technologie i koncepcje

* **Java 17**

### Zastosowane koncepcje OOP:
* **Dziedziczenie:** Klasa abstrakcyjna `Room` i klasy pochodne `SingleRoom`, `DormRoom`.
* **Interfejsy:** * `Bookable` - kontrakt dotyczący rezerwacji.
    * `Exportable` - kontrakt pozwalający na eksport danych do formatu CSV.
* **Polimorfizm:** Traktowanie różnych pokoi jako ogólny typ `Room` w listach i serwisach.
* **Kapsułkowanie:** Prywatne pola, gettery, zabezpieczona logika w konstruktorach (walidacja danych).

##  Funkcjonalności

1.  **Zarządzanie pokojami:** Dodawanie pokoi z walidacją danych (np. liczba łóżek musi być > 0).
2.  **System rezerwacji:** Sprawdzanie dostępności pokoi w zadanym terminie.
3.  **Raportowanie:** Generowanie raportów tekstowych (konsola) w formacie zbliżonym do CSV.
4.  **Obsługa gości:** Przechowywanie danych klientów.

##  Struktura projektu

* `hostel.app` - Klasa uruchomieniowa `Main` (symulacja działania systemu).
* `hostel.domain` - Klasy modelu (Room, Guest, Reservation) oraz interfejsy.
* `hostel.service` - Logika biznesowa (ReservationService, ReportingService).

##  Przykładowe działanie (Konsola)

```text
--- GENEROWANIE RAPORTÓW [03] ---

RAPORT: Wszystkie Pokoje
TYP;NR POKOJU;ŁÓŻKA;ZAJĘTY?;CENA;SZAFKI
SINGLE;101;1;false;100.0;0
SINGLE;102;1;false;120.0;0
DORM;201;6;true;50.0;6

RAPORT: Aktywne Rezerwacje
POKÓJ;GOŚĆ ID;OD;DO
101;G01;2023-12-01;2023-12-05

--- KONIEC PRACY SYSTEMU ---
