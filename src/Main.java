import jdk.jfr.Percentage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dane = Dane();
        Bilet(dane);
    }

    public static int getwiek() {
        try {
            System.out.println("Podaj wiek");
            Scanner scan = new Scanner(System.in);
            int wiek = scan.nextInt();

            if (wiek < 0 || wiek > 150) {
                throw new RuntimeException();
            }
            return wiek;
        } catch (Exception e) {
            throw new RuntimeException("Niepoprawny  wiek");
        }

    }

    public static String getmiasto() {
        try {
            System.out.println("Podaj miasto zamiekszkania");
            Scanner scan = new Scanner(System.in);
            return scan.next();
        } catch (Exception e) {
            throw new RuntimeException("Niepoprawne Miasto");
        }
    }

    public static String getdzień() {
        try {
            List<String> dni = Arrays.asList("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela");
            Set<String> dni1 = new HashSet<>(dni);

            System.out.println("Podaj dzień tygodnia");
            Scanner scan = new Scanner(System.in);
            String dzien = scan.nextLine();
            if (!(dni1.contains(dzien))) {
                throw new RuntimeException("Niepoprwany dzień");
            }
            return dzien;
        } catch (Exception e) {
            throw new RuntimeException("Niepoprawny dzień");
        }
    }

    public static ArrayList<String> Dane() {
        ArrayList<String> Wynik = new ArrayList<>();
        Wynik.add("Dane: ");
        Wynik.add(Integer.toString(getwiek()));
        Wynik.add(getmiasto());
        Wynik.add(getdzień());
        return Wynik;
    }

    public static ArrayList<String> Bilet(ArrayList<String> Dane) {
        double znizka = 0;
        double cena = 40;
        ArrayList<String> Wynik = new ArrayList<>();
        if (Integer.parseInt(Dane.get(1)) < 10) {
            cena = 0;
        }
        if (Integer.parseInt(Dane.get(1)) > 10 && Integer.parseInt(Dane.get(1)) < 18) {
            znizka = znizka + 0.5;
        }
        if (Dane.get(2).equals("Warszawa")) {
            znizka = znizka + 0.1;
        }
        if (Dane.get(3).equals("Czwartek")) {
            znizka = 1;
        }
        double cenaost = cena - cena * znizka;
        System.out.println("Dane: " + Dane.get(2) + ", " + Dane.get(1) + " lat, " + Dane.get(3));
        System.out.println("Cena biletu: " + cenaost + " zł");
        System.out.println("Zniżka: " + znizka * 100 + "%");
        Wynik.add((Dane.get(1)) + "lat");
        Wynik.add(Dane.get(2));
        Wynik.add(Dane.get(3));
        Wynik.add(znizka * 100 + "%");
        Wynik.add(cena - cena * znizka + " zł");
        return Wynik;
    }
}