package hostel.domain;

public class DormRoom extends PricedRoom {
    private final int lockers;

// konstruktor pokoju wieloosobowego    
    public DormRoom(String id, int beds, double price, int lockers) {
        super(id, beds, price); 
        if (lockers < 0) throw new IllegalArgumentException("lockers >= 0");
        this.lockers = lockers;
    }
// opis pokoju
    @Override
    public String description() {
        return "Dorm Room [ID: " + id + ", Beds: " + beds + ", Price: " + basePrice + "]";
    }

    @Override
    // eksport do formatu CSV
    public String toCsv() {
        return "DORM;" + id + ";" + beds + ";" + isOccupied() + ";" + basePrice + ";" + lockers;
    }
}