package hostel.domain;

import java.time.LocalDate;

public class Reservation implements Exportable {
    private final Guest guest;
    private final Room room;
    private final LocalDate from;
    private final LocalDate to;

    // konstruktor rezerwacji
    public Reservation(Guest guest, Room room, LocalDate from, LocalDate to) {
        if (guest == null) {
            throw new IllegalArgumentException("Gość nie może być null");
        }
        if (room == null) {
            throw new IllegalArgumentException("Pokój nie może być null");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Daty nie mogą być null");
        }
        if (to.isBefore(from)) {
            throw new IllegalArgumentException("Data końcowa nie może być przed początkową");
        }

        this.guest = guest;
        this.room = room;
        this.from = from;
        this.to = to;
    }
// pobranie gościa
    public Guest getGuest() {
        return guest;
    }
// pobranie pokoju
    public Room getRoom() {
        return room;
    }
// pobranie daty rozpoczęcia rezerwacji
    public LocalDate getFrom() {
        return from;
    }
// pobranie daty zakończenia rezerwacji
    public LocalDate getTo() {
        return to;
    }
// reprezentacja tekstowa rezerwacji
    @Override
    public String toString() {
        return String.format("Rezerwacja: %s dla %s (%s - %s)", 
            room.getId(), guest.getName(), from, to);
    }
// eksport rezerwacji do formatu CSV
    @Override
    public String toCsv() {
        return room.getId() + ";" + guest.getId() + ";" + from + ";" + to;
    }
}