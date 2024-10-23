package Oving8;

import java.util.Scanner;

public class klient {
    public static void main(String[] args) {
        Scanner moiScanner = new Scanner(System.in);

        Person personalia = new Person("Ingve", "Værnes", 2003);
        ArbTaker testObj1 = new ArbTaker(personalia, 5, 2022, 20000, 0.1);
        
        System.out.println("Skattetrekk: "+testObj1.ArbtkrSkattetrekk());
        System.out.println("Bruttolønn pr år: "+testObj1.bruttolonn());
        System.out.println("Skattetrekk per år: "+testObj1.skattetrekk());
        System.out.println("Navn: "+testObj1.PersonaliaNavn());
        System.out.println("Alder: "+testObj1.PeronaliaAlder());
        System.out.println("Antall år i bedrift: "+testObj1.antallAar());

        System.out.println("\nJobbet over visst år: ");
        int AktuellAar = moiScanner.nextInt();
        System.out.println("Om jobbet over aktuell år?: "+testObj1.OverVistAar(AktuellAar));
        moiScanner.close();
    }
}
