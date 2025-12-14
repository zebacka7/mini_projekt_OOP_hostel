package hostel.app;

import hostel.domain.DormRoom;
import hostel.domain.Guest;
import hostel.domain.Room;
import hostel.domain.SingleRoom;
import hostel.service.ReportingService;
import hostel.service.ReservationService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        

        ReservationService reservationService = new ReservationService(); 
        ReportingService reportingService = new ReportingService();
        
        reservationService.addRoom(new SingleRoom("101", 100.0));
        reservationService.addRoom(new SingleRoom("102", 120.0));
        reservationService.addRoom(new DormRoom("201", 6, 50.0, 6));
        
        Guest guest1 = new Guest("G01", "Jan Kowalski", "jan@o2.pl");
        reservationService.book(guest1, reservationService.getAllRooms().get(0), LocalDate.now(), LocalDate.now().plusDays(5));


        System.out.println("\n--- GENEROWANIE RAPORTÓW [03] ---\n");

  // raport pokoje - dodajemy nagłówek kolumn
        reportingService.generateReport(
                "Wszystkie Pokoje",
                "TYP;NR POKOJU;ŁÓŻKA;ZAJĘTY?;CENA;SZAFKI", 
                reservationService.getAllRooms()
        );

// raport rezerwacje - dodajemy nagłówek kolumn
        reportingService.generateReport(
                "Aktywne Rezerwacje",
                "POKÓJ;GOŚĆ ID;OD;DO", 
                reservationService.getAllReservations()
        );

        System.out.println("--- KONIEC PRACY SYSTEMU ---");
    }
}