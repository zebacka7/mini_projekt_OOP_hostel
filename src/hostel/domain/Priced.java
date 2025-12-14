package hostel.domain;

import java.time.LocalDate;
// interfejs dla obiektów posiadających cenę
public interface Priced {
    double getPrice(LocalDate date);
}