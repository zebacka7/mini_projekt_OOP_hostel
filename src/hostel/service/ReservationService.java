package hostel.service;

import hostel.domain.Guest;
import hostel.domain.Reservation;
import hostel.domain.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationService {
// lista pokoi w hostelu oraz lista rezerwacji
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
// metoda dodająca pokój do oferty hostelu
    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }
// metoda dokonująca rezerwacji
    public Reservation book(Guest guest, Room room, LocalDate from, LocalDate to) {
        if (guest == null || room == null) {
            throw new IllegalArgumentException("Gość i pokój nie mogą być null");
        }

// sprawdzenie dostępności pokoju
        if (room.isAvailable()) {
            
            room.book();

            Reservation reservation = new Reservation(guest, room, from, to);

            reservations.add(reservation);

            return reservation;
        } else {
            throw new IllegalStateException("Pokój " + room.getId() + " jest już zajęty.");
        }
    }
// metoda anulująca rezerwację
    public void cancel(Reservation reservation) {
        if (reservation != null && reservations.contains(reservation)) {
            reservation.getRoom().cancel();

            reservations.remove(reservation);
        } else {
            System.out.println("Nie znaleziono podanej rezerwacji.");
        }
    }
// pobieranie listy wszystkich pokoi
    public List<Room> getAllRooms() {
        return Collections.unmodifiableList(rooms);
    }
// pobieranie listy wszystkich rezerwacji
    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(reservations);
    }
}