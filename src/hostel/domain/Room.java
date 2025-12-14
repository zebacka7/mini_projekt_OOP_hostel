package hostel.domain;

public abstract class Room implements Bookable, Exportable
{
protected final String id; 
protected final int beds;
private boolean occupied;
// konstruktor pokoju
protected Room(String id, int beds)
    {
    this.id = id;
    this.beds = beds;
    this.occupied = false;
    }
// rezerwacja pokoju
    @Override
    public void book() {
        occupy(); 
    }
// anulowanie rezerwacji
    @Override
    public void cancel() {
        release();
    }
// sprawdzenie dostępności pokoju
    @Override
    public boolean isAvailable() {
        return !isOccupied();
    }
// sprawdzenie czy pokój jest zajęty
 public boolean isOccupied()
    {
    return occupied;
    }
// oznaczenie pokoju jako zajętego
    void occupy()
    {
        this.occupied = true;
    }
// oznaczenie pokoju jako wolnego
    void release()
    {
        this.occupied = false;
    }

// pobranie ID pokoju
    public String getId() {
    return id;
}
    // opis pokoju
    public abstract String description();
    
}
