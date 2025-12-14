package hostel.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
// abstrakcyjna klasa pokoju z ceną
public abstract class PricedRoom extends Room implements Priced {
    
    protected final double basePrice;

    protected PricedRoom(String id, int beds, double basePrice) {
        super(id, beds);
        this.basePrice = basePrice;
    }

// implementacja ceny w zależności od dnia tygodnia
    @Override
    public double getPrice(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        
// sobota niedzielea --> +20% do ceny bazowej
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return basePrice * 1.20;
        }
        

        return basePrice;
    }
// pobranie ceny bazowej
    public double getBasePrice() {
        return basePrice;
    }
}