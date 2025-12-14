package hostel.domain;

public class SingleRoom extends PricedRoom {

    // konstruktor pokoju jednoosobowego
    public SingleRoom(String id, double price) {
        super(id, 1, price); }

    @Override
    // opis pokoju
    public String description() {
        return "Single Room [ID: " + id + ", Price: " + basePrice + "]";
    }

    @Override
    // eksport do formatu CSV
    public String toCsv() {
        return "SINGLE;" + id + ";" + beds + ";" + isOccupied() + ";" + basePrice;
    }
}