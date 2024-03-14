import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Testbilet {

    @Test
    void bilet() {
        boolean wynik = false;

        ArrayList<String> Dane = new ArrayList<>();
        Dane.add("Dane");
        Dane.add("11");
        Dane.add("Warszawa");
        Dane.add("Sobota");
        ArrayList<String> Dane1 = Main.Bilet(Dane);
        String zniżka = Dane1.get(3);
        String cena = Dane1.get(4);
        if (zniżka.equals("60.0%") && cena.equals("16.0 zł")) {
            wynik = true;
        }
        assertTrue(wynik);
    }
}
