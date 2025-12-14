package hostel.service;

import hostel.domain.Exportable;
import java.util.List;

public class ReportingService {
// metoda generująca raport
    public void generateReport(String reportName, String headerRaw, List<? extends Exportable> items) {
        System.out.println("\n================================================================");
        System.out.println("   RAPORT: " + reportName.toUpperCase());
        System.out.println("================================================================");
// sprawdzanie czy lista jest pusta
        if (items.isEmpty()) {
            System.out.println("(Brak danych do wyświetlenia)");
        } else {
            printRow(headerRaw.split(";"));
            System.out.println("----------------------------------------------------------------");

            // wyświetlanie danych
            for (Exportable item : items) {
                String[] data = item.toCsv().split(";");
                printRow(data);
            }
        }
        System.out.println("================================================================\n");
    }

// pomocnicza metoda do formatowanego wyświetlania wiersza
    private void printRow(String[] columns) {
        for (String col : columns) {
            System.out.printf("%-15s", col); 
        }
        System.out.println(); 
    }
}